#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

fn calculate_rect() {
    let rect1 = Rectangle { width: 30, height: 50 };

    println!("rect1 is {:?}", rect1); // or {:#?}
}
