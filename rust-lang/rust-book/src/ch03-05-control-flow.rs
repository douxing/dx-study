/*
if Expressions:

condition, also called arms, must be a bool
*/
fn if_expression() {
    let number = 3;

    // we call 'number < 5', the conditions, arms
    if number < 5 {
        println!("condition was true");
    } else {
        println!("condition was false");
    }
}

/*
Using if in a let statement

the values that have the potential to be results
from each arm of the if MUST BE THE SAME TYPE
*/
fn if_in_a_let_statement() {
    let condition = true;
    let number = if condition {
        5
    } else {
        6 // 'six' then compile error
    };

    println!("The value of number is: {}", number);
}

/*
Repetition with Loops
*/
fn with_loop() {
    loop {
        println!("again!");
    }
}

fn with_while() {
    let mut number = 3;

    while number != 0 {
        println!("{}!", number);

        number = number - 1;
    }

    println!("LIFTOFF!!!");
}

fn with_for() {
    let a = [10, 20, 30, 40, 50];
    let mut index = 0;

    while index < 5 {
        println!("the value is: {}", a[index]);

        index = index + 1;
    }

    for element in a.iter() {
        println!("the value is: {}", element);
    }
}

fn with_for_range() {
    for number in (1..4).rev() {
        println!("{}!", number);
    }
    println!("LIFTOFF!!!");    
}
