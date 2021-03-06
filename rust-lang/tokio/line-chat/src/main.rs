extern crate tokio;
#[macro_use]
extern crate futures;
extern crate bytes;

use tokio::io;
use tokio::net::{TcpListener, TcpStream};
use tokio::prelude::*;
use futures::sync::mpsc;
use futures::future::{self, Either};
use bytes::{BytesMut, Bytes, BufMut};

use std::collections::HashMap;
use std::net::SocketAddr;
use std::sync::{Arc, Mutex};

/// Shorthand for the transmit half of the message channel.
type Tx = mpsc::UnboundedSender<Bytes>;

/// Shorthand for the transmit half of the message channel.
type Rx = mpsc::UnboundedReceiver<Bytes>;

struct Shared {
    peers: HashMap<SocketAddr, Tx>,
}

struct Peer {
    name: BytesMut,
    lines: Lines,
    state: Arc<Mutex<Shared>>,
    rx: Rx,
    addr: SocketAddr,
}

#[derive(Debug)]
struct Lines {
    socket: TcpStream,
    rd: BytesMut,
    wr: BytesMut,
}

impl Shared {
    fn new() -> Self {
        Shared {
            peers: HashMap::new(),
        }
    }
}

impl Peer {
    fn new(name: BytesMut,
           state: Arc<Mutex<Shared>>,
           lines: Lines) -> Peer {
        let addr = lines.socket.peer_addr().unwrap();

        let (tx, rx) = mpsc::unbounded();

        state.lock().unwrap().peers.insert(addr, tx);

        Peer {
            name,
            lines,
            state,
            rx,
            addr,
        }
    }
}

impl Future for Peer {
    type Item = ();
    type Error = io::Error;

    fn poll(&mut self) -> Poll<(), io::Error> {
        const LINES_PER_TICK: usize = 10;

        for i in 0..LINES_PER_TICK {
            match self.rx.poll().unwrap() {
                Async::Ready(Some(v)) => {
                    self.lines.buffer(&v);

                    if i + 1 == LINES_PER_TICK {
                        task::current().notify();
                    }
                },
                _ => break,
            }
        }

        let _ = self.lines.poll_flush()?;

        while let Async::Ready(line) = self.lines.poll()? {
            println!("Received line({:?}): {:?}", self.name, line);

            if let Some(message) = line {
                let mut line = self.name.clone();
                line.extend_from_slice(b": ");
                line.extend_from_slice(&message);
                line.extend_from_slice(b"\r\n");

                let line = line.freeze();

                for (addr, tx) in &self.state.lock().unwrap().peers {
                    if *addr != self.addr {
                        tx.unbounded_send(line.clone()).unwrap();
                    }
                }
            } else {
                return Ok(Async::Ready(()));
            }
        }

        Ok(Async::NotReady)
    }
}

impl Drop for Peer {
    fn drop(&mut self) {
        self.state.lock().unwrap().peers.remove(&self.addr);
    }
}

impl Lines {
    fn new(socket: TcpStream) -> Self {
        Lines {
            socket,
            rd: BytesMut::new(),
            wr: BytesMut::new(),
        }
    }

    fn buffer(&mut self, line: &[u8]) {
        self.wr.reserve(line.len());
        self.wr.put(line);
    }

    fn poll_flush(&mut self) -> Poll<(), io::Error> {
        while !self.wr.is_empty() {
            let n = try_ready!(self.socket.poll_write(&self.wr));

            assert!(n > 0);

            let _ = self.wr.split_to(n);
        }

        Ok(Async::Ready(()))
    }

    fn fill_read_buf(&mut self) -> Poll<(), io::Error> {
        loop {
            self.rd.reserve(1024);

            let n = try_ready!(self.socket.read_buf(&mut self.rd));

            if n == 0 {
                return Ok(Async::Ready(()));
            }
        }
    }
}

impl Stream for Lines {
    type Item = BytesMut;
    type Error = io::Error;

    fn poll(&mut self) -> Poll<Option<Self::Item>, Self::Error> {
        let sock_closed = self.fill_read_buf()?.is_ready();

        let pos = self.rd.windows(2).enumerate()
            .find(|&(_, bytes)| bytes == b"\r\n")
            .map(|(i, _)| i);

        if let Some(pos) = pos {
            let mut line = self.rd.split_to(pos + 2);

            line.split_off(pos);

            return Ok(Async::Ready(Some(line)));
        }

        if sock_closed {
            Ok(Async::Ready(None))
        } else {
            Ok(Async::NotReady)
        }
    }
}

fn process(socket: TcpStream, state: Arc<Mutex<Shared>>) {
    let lines = Lines::new(socket);

    let connection = lines.into_future()
        .map_err(|(e, _)| e)
        .and_then(|(name, lines)| {
            let name = match name {
                Some(name) => name,
                None => {
                    return Either::A(future::ok(()));
                },
            };

            println!("`{:?}` is joining the chat", name);

            let peer = Peer::new(
                name, state, lines
            );

            Either::B(peer)
        })
        .map_err(|e| {
            println!("connection error = {:?}", e)
        });

    tokio::spawn(connection);
}

fn main() {
    let state = Arc::new(Mutex::new(Shared::new()));

    let addr = "127.0.0.1:6142".parse().unwrap();

    let listener = TcpListener::bind(&addr).unwrap();

    let server = listener.incoming().for_each(move |socket| {
        process(socket, state.clone());
        Ok(())
    })
        .map_err(|err| {
            // Handle error by printing to STDOUT.
            println!("accept error = {:?}", err);
        });

    println!("server running on localhost:6142");

    // Start the server
    //
    // This does a few things:
    //
    // * Start the Tokio runtime (reactor, threadpool, etc...)
    // * Spawns the `server` task onto the runtime.
    // * Blocks the current thread until the runtime becomes idle, i.e. all
    //   spawned tasks have completed.
    tokio::run(server);
}
