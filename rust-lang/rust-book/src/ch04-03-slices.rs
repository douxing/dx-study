fn first_word(s: &String) -> &str {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[0..i];
        }
    }

    &s[..]
}

/*
String Literals are Slices

let s: &str = "Hello, world!";
*/

fn other_slices() {
    let a = [1, 2, 3, 4, 5];

    let slice = &a[1..3]; // of type &[i32]

    println!("{}", slice);
}
