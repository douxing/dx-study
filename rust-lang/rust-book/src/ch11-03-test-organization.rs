/*
Testing private functions with unit test
*/
pub fn add_two(a: i32) -> i32 {
    internal_adder(a, 2)
}

fn internal_adder(a: i32, b: i32) -> i32 {
    a + b
}

#[cfg(test)] // unit test needs configure
mod tests {
    use super::*;

    #[test]
    fn internal() {
        assert_eq!(4, internal_adder(2, 2));
    }
}

/*
Integration Tests
*/
// need import
extern crate adder;

#[test]
fn it_adds_two() {
    assert_eq!(4, adder::add_two(2));
}

/*
Integration Tests for Binary Crates
If our project is a binary crate that only contains a src/main.rs and does not have a src/lib.rs, we aren’t able to create integration tests in the tests directory and use extern crate to import functions defined in src/main.rs. Only library crates expose functions that other crates are able to call and use; binary crates are meant to be run on their own.

This is one of the reasons Rust projects that provide a binary have a straightforward src/main.rs that calls logic that lives in src/lib.rs. With that structure, integration tests can test the library crate by using extern crate to cover the important functionality. If the important functionality works, the small amount of code in src/main.rs will work as well, and that small amount of code does not need to be tested.
*/
