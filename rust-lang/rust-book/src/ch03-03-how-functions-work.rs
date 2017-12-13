/*
parameters(形参):
special variables that are part of a function’s signature

arguments(实参):
concrete values for those parameters
*/

/*
In function signatures, you must declare the type of each parameter.
This is a deliberate decision in Rust’s design:
requiring type annotations in function definitions means
the compiler almost never needs you to use them elsewhere
in the code to figure out what you mean.
 */

/*
Statements and Expressions

Calling a function is an expression.
Calling a macro is an expression.
The block that we use to create new scopes, {}, is an expression.
 */
fn expression() {
    let x = 5;

    let y = {
        let x = 3;
        x + 1 // <- no semicolon then expression, or statement
    };

    println!("The value of y is: {}", y);
}

fn call_plus_one() {
    let x = plus_one(5);

    println!("The value of x is: {}", x);
}

fn plus_one(x: i32) -> i32 {
    x + 1 // <- no semicolon
}

