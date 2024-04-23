extern crate regex;

use regex::Regex;

fn main() {
    let sentence = "We're all dorks!";
    println!("{}", reverse_string(sentence).to_string());
}

fn reverse_string(string: &str) -> String {
    let re = Regex::new(r"\b|\s").unwrap();
    let split = re.split(string);
    let mut accumulator = Vec::new();
    for word in split {
        accumulator.push(reverse_word(word));
    }
    accumulator.join("")
}

fn reverse_word(word: &str) -> String {
    word.chars().rev().collect::<String>()
}

#[test]
fn test_easy_string() {
    assert_eq!(reverse_string("Hello World"), "olleH dlroW");
}

#[test]
fn test_end_punctuation() {
    assert_eq!(reverse_string("This is a string."), "sihT si a gnirts.");
}

#[test]
fn test_hardest() {
    assert_eq!(reverse_string("Hey! That's a string with stuff in it. I wonder if I can handle that?"), "yeH! tahT's a gnirts htiw ffuts ni ti. I rednow fi I nac eldnah taht?")
}
