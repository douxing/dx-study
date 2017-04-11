package main

import (
"fmt"
)

func odd_subs(s string, pos int) string {
	fmt.Println("in odd_subs")
	var cwl = 0 // current wing len
	
	for pos + cwl < len(s) && pos - cwl >= 0 {
		if s[pos + cwl] == s[pos - cwl] {
			cwl++
		} else {
			break
		}
	}
	
	fmt.Println(pos, cwl)

	return s[pos - cwl + 1:pos + cwl]
}

func even_subs(s string, pos int) string {
	fmt.Println("in even_subs")
	var rpos = pos + 1
	
	if rpos >= len(s) {
		return ""
	}

	for rpos < len(s) && pos >= 0 {
		if s[pos] == s[rpos] {
			pos--
			rpos++
		} else {
			break
		}
	}
	
	fmt.Println(pos, rpos)

	return s[pos + 1:rpos]
}

func longestPalindrome(s string) string {
	if len(s) == 0 {
		return ""
	}

	var mss = ""// max substring
	var mss_len = 0
	
	for i := 0; i < len(s); i++ {
		odd, even := odd_subs(s, i), even_subs(s, i)
		odd_len, even_len := len(odd), len(even)

		fmt.Println("odd even index: ", odd, even, i)

		var cmss string
		var cmss_len int
		if odd_len > even_len {
			cmss = odd
			cmss_len = odd_len
		} else {
			cmss = even
			cmss_len = even_len
		}

		if cmss_len > mss_len {
			mss = cmss
			mss_len = cmss_len
		}
	}

	return mss
}

// func main() {
// 	fmt.Println("result: ", longestPalindrome("abbbfafafba"))
// }
