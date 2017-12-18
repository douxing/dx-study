/*
Lifetime Annotation Syntax:

&i32        // a reference
&'a i32     // a reference with an explicit lifetime
&'a mut i32 // a mutable reference with an explicit lifetime
*/

/*
Lifetime Annotations in Function Signatures
*/
fn longest<'a>(x: &'a str, y: &'a str) -> &'a str {
    if x.len() > y.len() {
        x
    } else {
        y
    }
}

/*
Lifetime Annotations in Struct Definitions
*/

struct ImportantExcerpt<'a> {
    part: &'a str,
}

fn lifetime_annotations_in_struct_definitions() {
    let novel = String::from("Call me Ishmael. Some years ago...");
    let first_sentence = novel.split('.')
        .next()
        .expect("Could not find a '.'");
    let i = ImportantExcerpt { part: first_sentence };
}

/*
Lifetime Elison

1. Each parameter that is a reference gets its own lifetime parameter.
   In other words, a function with one parameter gets one lifetime parameter:
     fn foo<'a>(x: &'a i32),
   a function with two arguments gets two separate lifetime parameters:
     fn foo<'a, 'b>(x: &'a i32, y: &'b i32), and so on.

2. If there is exactly one input lifetime parameter,
   that lifetime is assigned to all output lifetime parameters:
   fn foo<'a>(x: &'a i32) -> &'a i32.

3. If there are multiple input lifetime parameters,
   but one of them is &self or &mut self because this is a method,
   then the lifetime of self is assigned to all output lifetime parameters.
   This makes writing methods much nicer.
*/

// an example where the third lifetime elision rule applies:
impl<'a> ImportantExcerpt<'a> {
    fn announce_and_return_part(&self, announcement: &str) -> &str {
        println!("Attention please: {}", announcement);
        self.part
    }
}

// static lifetime
// let s: &'static str = "I have a static lifetime.";

/*
Generic Type Parameters, Trait Bounds, and Lifetimes Together
*/
use std::fmt::Display;

fn longest_with_an_announcement<'a, T>(x: &'a str, y: &'a str, ann: T) -> &'a str
    where T: Display
{
    println!("Announcement! {}", ann);
    if x.len() > y.len() {
        x
    } else {
        y
    }
}
