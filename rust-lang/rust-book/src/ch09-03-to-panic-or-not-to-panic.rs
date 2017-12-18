/*
All Places it’s Perfectly Fine to Panic:
1. Examples
2. Prototype Code
3. Tests

Cases When You Have More Information Than the Compiler:

use std::net::IpAddr;
let home = "127.0.0.1".parse::<IpAddr>().unwrap();
// assert home is Ok(IpAddr)
*/

/*
Guidelines for Error Handling

if input are from other programmers: panic!
if input are from other end-users  : Result
*/

/*
Creating Custom Types for Validation
*/

fn before_custom_types_for_validation() {
    loop {
        // snip

        let guess: i32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => continue,
        };

        // condition here!
        // every time we have to check this condition
        if guess < 1 || guess > 100 {
            println!("The secret number will be between 1 and 100.");
            continue;
        }

        match guess.cmp(&secret_number) {
            // snip
        }
    }
}

// or we can

pub struct Guess {
    value: u32,
}

impl Guess {
    pub fn new(value: u32) -> Guess {
        // panic! if pre-condition not satisfied
        if value < 1 || value > 100 {
            panic!("Guess value must be between 1 and 100, got {}.", value);
        }

        Guess {
            value
        }
    }

    // then we are sure that self.value is between 1 and 100
    pub fn value(&self) -> u32 {
        self.value
    }
}
