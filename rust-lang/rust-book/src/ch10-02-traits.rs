pub trait Summarizable {
    fn summary(&self) -> String;
}

/*
Implementing a Trait on a Type
*/
pub struct NewsArticle {
    pub headline: String,
    pub location: String,
    pub author: String,
    pub content: String,
}

impl Summarizable for NewsArticle {
    fn summary(&self) -> String {
        format!("{}, by {} ({})", self.headline, self.author, self.location)
    }
}

pub struct Tweet {
    pub username: String,
    pub content: String,
    pub reply: bool,
    pub retweet: bool,
}

impl Summarizable for Tweet {
    fn summary(&self) -> String {
        format!("{}: {}", self.username, self.content)
    }
}

/*
Default Implementations
*/
pub trait Summarizable {
    fn author_summary(&self) -> String;

    fn summary(&self) -> String {
        // can event call UNIMPLEMENTED method
        format!("(Read more from {}...)", self.author_summary())
    }
}

/*
Trait Bounds
*/
pub fn notify<T: Summarizable>(item: T) {
    println!("Breaking news! {}", item.summary());
}

fn some_function<T: Display + Clone, U: Clone + Debug>(t: T, u: U) -> i32 {}

fn some_function_1<T, U>(t: T, u: U) -> i32
    where T: Display + Clone,
          U: Clone + Debug
{}

// Fixing the largest Function with Trait Bounds
// in next chapter
use std::cmp::PartialOrd;

fn largest<T: PartialOrd + Copy>(list: &[T]) -> T {
    let mut largest = list[0];

    for &item in list.iter() {
        if item > largest {
            largest = item;
        }
    }

    largest
}

fn using_largest() {
    let number_list = vec![34, 50, 25, 100, 65];

    let result = largest(&number_list);
    println!("The largest number is {}", result);

    let char_list = vec!['y', 'm', 'a', 'q'];

    let result = largest(&char_list);
    println!("The largest char is {}", result);
}

/*
Using Trait Bounds to Conditionally Implement Methods
*/
use std::fmt::Display;

struct Pair<T> {
    x: T,
    y: T,
}

impl<T> Pair<T> {
    fn new(x: T, y: T) -> Self {
        Self {
            x,
            y,
        }
    }
}

impl<T: Display + PartialOrd> Pair<T> {
    fn cmp_display(&self) {
        if self.x >= self.y {
            println!("The largest member is x = {}", self.x);
        } else {
            println!("The largest member is y = {}", self.y);
        }
    }
}

/*
blanket implementations
*/

impl<T: Display> ToString for T {
    // ...snip...
}

// then we can use
// let s = 3.to_string();
