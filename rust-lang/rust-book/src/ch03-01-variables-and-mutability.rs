
/*
constants
1. the type of the value must be annotated
2. may only be set to a constant expression,
   not the result of a function call or any
   other value that could only be computed at runtime
*/
const MAX_POINTS: u32 = 100_000; 

/*
mutable variables
can only change mut variables
let x = 5;
x = 6; <- won't compile
*/
fn mutable_variables() {
    let mut x = 5; // 
    println!("The value of x is: {}", x);
    x = 6;
    println!("The value of x is: {}", x);
}

/*
shadowing
1. can declare a new variable with the same name as a previous variable,
   and the new variable shadows the previous variable
2. can shadow a variable by using the same variable’s name
   and repeating the use of the let keyword
*/
fn shadowing() {
    let x = 5;

    let x = x + 1;

    let x = x * 2;

    println!("The value of x is: {}", x);
}


