/*
A data race:

1. Two or more pointers access the same data at the same time.
2. At least one of the pointers is being used to write to the data.
3. There’s no mechanism being used to synchronize access to the data.

so in the same scope:
1. mutable borrow: atmost once
2. immutable borrow: no limit, but no more mutable borrow
*/

/*
Dangling References
*/
fn no_dangle() -> String {
    let s = String::from("hello");

    s // if &s then compile error
}

/*
The Rules of References

1. At any given time, you can have either but not both of:
  - One mutable reference.
  -  Any number of immutable references.
2. References must always be valid.
*/
