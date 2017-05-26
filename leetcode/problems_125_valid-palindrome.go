package main

import (
	"fmt"
)

func isAlphaNumeric(c byte) bool {
	if 'A' <= c && c <= 'Z' ||
		'a' <= c && c <= 'z' ||
		'0' <= c && c <= '9' {
		return true
	}

	return false
}

func toLowerCase(c byte) byte {
	if 'A' <= c && c <= 'Z' {
		return c + 'a' - 'A'
	}

	return c
}

func isPalindrome(s string) bool {
	lindex, rindex := 0, len(s) - 1

	for  lindex < rindex {
		if !isAlphaNumeric(s[lindex]) {
			lindex++
			continue
		}

		if !isAlphaNumeric(s[rindex]) {
			rindex--
			continue
		}

		if toLowerCase(s[lindex]) != toLowerCase(s[rindex]) {
			return false
		}

		lindex++
		rindex--
	}

	return true	
}

func main() {
	fmt.Println(isPalindrome("A man, a plan, a canal: Panama"))
	fmt.Println(isPalindrome("race a car"))
}
