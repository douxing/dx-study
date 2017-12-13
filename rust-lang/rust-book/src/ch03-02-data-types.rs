/*
Rust is a statically typed language,
which means that it must know the
types of all variables at compile time
example:

let guess: u32 = "42".parse().expect("Not a number!");

u32 is needed, or a compile error
*/

/*
Scalar Types

Rust has four primary scalar types:
1. integers
2. floating-point numbers
3. booleans
4. characters
*/

/*
Integer Tyeps

Length	Signed	Unsigned
8-bit	i8	u8
16-bit	i16	u16
32-bit	i32	u32
64-bit	i64	u64
arch	isize	usize

all number literals except the byte literal allow a type suffix,
such as 57u8, and _ as a visual separator, such as 1_000


Number literals	Example
Decimal         98_222
Hex	        0xff
Octal	        0o77
Binary	        0b1111_0000
Byte (u8 only)	b'A'

integer types default to i32
*/

/*
Floating-Point Types

f64 <- default
f32
*/

/*
Numeric Operations
*/
fn numeric_operations() {
    // addition
    let sum = 5 + 10;

    // subtraction
    let difference = 95.5 - 4.3;

    // multiplication
    let product = 4 * 30;

    // division
    let quotient = 56.7 / 32.2;

    // remainder
    let remainder = 43 % 5;
}

/*
The Boolean Type
*/
fn the_boolean_type() {
    let t = true;

    let f: bool = false; // with explicit type annotation
}

/*
The Character Type

Rust’s char type represents a Unicode Scalar Value
*/
fn the_char_type() {
   let c = 'z';
   let z = 'ℤ';
   let heart_eyed_cat = '😻';
}

/*
Compound Types

Compound types can group multiple values of other types into one type.
Rust has two primitive compound types: tuples and arrays.
*/

/*
Grouping Values into Tuples
*/
fn tuple() {
    let tup: (i32, f64, u8) = (500, 6.4, 1);

    let (x, y, z) = tup;

    println!("The value of y is: {}", y);    
}

fn access_a_tulpe_element() {
    let x: (i32, f64, u8) = (500, 6.4, 1);

    let five_hundred = x.0;

    let six_point_four = x.1;

    let one = x.2;
}

/*
Arrays

Unlike a tuple, every element of an array must have the same type.

Unlike some other languages, arrays in Rust have a fixed length:
once declared, they cannot grow or shrink in size.
*/

fn array_index() {
    let a = [1, 2, 3, 4, 5];
    let index = 10;

    let element = a[index]; // <- runtime error

    println!("The value of element is: {}", element);
}



