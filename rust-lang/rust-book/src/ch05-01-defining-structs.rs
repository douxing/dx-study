#[derive(Debug)]
struct User {
    username: String,
    email: String,
    sign_in_count: u64,
    active: bool,
}

fn build_user(email: String, username: String) -> User {
    User {
        email,
        username,
        active: true,
        sign_in_count: 1,
    }
}

fn init_and_update() {
    let user1 = User {
        email: String::from("someone@example.com"),
        username: String::from("someusername123"),
        active: true,
        sign_in_count: 1,
    };

    let user2 = User {
        email: String::from("someone@example.com"),
        username: String::from("someusername123"),
        ..user1
    };

    println!("user1: {:?}", user1);
    println!("user2: {:?}", user2);
}

/*
Tuple Structs without Named Fields to Create Different Types
*/
fn tuple_structs() {
    struct Color(i32, i32, i32);
    struct Point(i32, i32, i32);

    // black and origin values are different types
    let black = Color(0, 0, 0);
    let origin = Point(0, 0, 0);

}

/*
Unit-like Structs

can be useful in situations such as
when you need to implement a trait on some type, 
but you don’t have any data that you want to store in the type itself
*/
