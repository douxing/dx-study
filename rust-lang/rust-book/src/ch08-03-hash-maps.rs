// not included by prelude
use std::collections::HashMap;

fn construct_by_iter_and_collect() {
    let teams  = vec![String::from("Blue"), String::from("Yellow")];
    let initial_scores = vec![10, 50];

    let scores: HashMap<_, _> = teams.iter().zip(initial_scores.iter()).collect();
}

fn get_and_iterate_get() {

    let mut scores = HashMap::new();

    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    let team_name = String::from("Blue");
    // returns Option<&v>
    let score = scores.get(&team_name);

    for (key, value) in &scores {
        println!("{}: {}", key, value);
    }
}

fn update_a_hash_map() {
    let mut scores = HashMap::new();

    // insert and replace
    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Blue"), 25);

    // keep old or insert new
    scores.entry(String::from("Yellow")).or_insert(50);
    scores.entry(String::from("Blue")).or_insert(50);

    // example to update score by one
    // if not exist, init with 0 first
    let text = "hello world wonderful world";

    let mut map = HashMap::new();

    for word in text.split_whitespace() {
        // or_insert returns a mutable ref (&mut V)
        let count = map.entry(word).or_insert(0);
        *count += 1;
    }
    

    println!("{:?}", scores);    
}

fn summary_1() {
    let mut ivec: Vec<i32> = vec![1,2,3,4,5,6,7,8,9,8];
    ivec.sort();

    let l = ivec.len();
    let middle = ivec[l / 2];

    let mut total = 0f64;
    let mut imap: HashMap<i32, u32> = HashMap::new();
    for i in &ivec {
        total += *i as f64;
        let count = imap.entry(*i).or_insert(0);
        *count += 1;
    }

    let mut maxi = ivec[0];
    let mut maxi_count = 0u32;
    
    for (i, count) in imap {
        if count > maxi_count {
            maxi = i;
            maxi_count = count;
        }
    }

    println!("avg: {}, mid: {}, maxi: {}", total / l as f64, middle, maxi);
}
