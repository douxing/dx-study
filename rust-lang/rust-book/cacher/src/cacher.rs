use std::collections::HashMap;

pub struct Cacher<T, U>
{
    calculation: Fn(T) -> U,
    values: HashMap<T, U>,
}
