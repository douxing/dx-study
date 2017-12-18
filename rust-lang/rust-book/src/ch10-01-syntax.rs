struct Point<T, U> {
    x: T,
    y: U,
}

fn points_with_diff_templates() {
    let both_integer = Point { x: 5, y: 10 };
    let both_float = Point { x: 1.0, y: 4.0 };
    let integer_and_float = Point { x: 5, y: 4.0 };
}

// T, U for Point in impl
// V, W for Point in mixup parameters
impl<T, U> Point<T, U> {
    fn mixup<V, W>(self, other: Point<V, W>) -> Point<T, W> {
        Point {
            x: self.x,
            y: other.y,
        }
    }
}

fn use_mixup() {
    let p1 = Point { x: 5, y: 10.4 };
    let p2 = Point { x: "Hello", y: 'c'};

    let p3 = p1.mixup(p2);

    println!("p3.x = {}, p3.y = {}", p3.x, p3.y);
}

/*
what happens when we defind:

let integer = Some(5);
let float = Some(5.0);

*/
enum Option_i32 {
    Some(i32),
    None,
}

enum Option_f64 {
    Some(f64),
    None,
}

fn monomorphization() {
    let integer = Option_i32::Some(5);
    let float = Option_f64::Some(5.0);
}
