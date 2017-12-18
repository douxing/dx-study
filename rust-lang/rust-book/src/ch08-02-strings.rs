/*
1. &str vs String, OsString, OsStr, CString, CStr
2. "hello".to_string() is the same as String.from("hello")
*/

fn appending_to_a_string() {
    let mut s = String::from("foo");
    s.push_str("bar");


    let mut s = String::from("lo");
    s.push('l');
}

fn concat_with_plus_for_format() {

    let s1 = String::from("tic");
    let s2 = String::from("tac");
    let s3 = String::from("toe");

    // Note that s1 has been moved here and can no longer be used
    let s = s1 + "-" + &s2 + "-" + &s3;

    let s1 = String::from("tic");
    let s2 = String::from("tac");
    let s3 = String::from("toe");

    // s1 is still valid
    let s = format!("{}-{}-{}", s1, s2, s3);
}

fn methods_for_iterating_over_strings() {
    for c in "नमस्ते".chars() {
        println!("{}", c);
    }

    for b in "नमस्ते".bytes() {
        println!("{}", b);
    }
}
