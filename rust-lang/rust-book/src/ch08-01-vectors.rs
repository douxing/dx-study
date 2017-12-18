/*
*/

fn iterating_over_the_values_in_a_vector() {
    let v = vec![100, 32, 57];
    for i in &v {
        println!("{}", i);
    }

    let mut v = vec![100, 32, 57];
    for i in &mut v {
        *i += 50;
    }
}

fn change_to_elements() {
    let mut v = vec![100, 32, 57];
    for i in &mut v {
        *i += 50;
    }
}

fn using_an_enum_to_store_multiple_types() {
    enum SpreadsheetCell {
        Int(i32),
        Float(f64),
        Text(String),
    }

    let row = vec![
        SpreadsheetCell::Int(3),
        SpreadsheetCell::Text(String::from("blue")),
        SpreadsheetCell::Float(10.12),
    ];
}
