package main

import (
	"fmt"
)

/*
func isIsomorphic(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	var s1 string = ""
	var hash = make(map[string]string)
	var rhash = make(map[string]string)

	for i := 0; i < len(s); i++ {
		subs := s[i:i+1]

		if subt, ok := hash[subs]; ok {
			s1 = s1 + subt
		} else {
			if _, ok := rhash[t[i:i+1]]; ok {
				// it is a one-one mapping
				break
			}
			hash[subs] = t[i:i+1]
			rhash[t[i:i+1]] = subs
			s1 = s1 + t[i:i+1]
		}
	}

	return s1 == t
}
*/

/* 
func isIsomorphic(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	var shash = make(map[byte]byte)
	var thash = make(map[byte]byte)

	for i := 0; i < len(s); i++ {
		sb, sok := shash[byte(s[i])]
		tb, tok := thash[byte(t[i])]

		if sok != tok {
			return false
		}

		if sok == true && (sb != byte(t[i]) || tb != byte(s[i])) {
			return false
		}
		
		shash[byte(s[i])] = byte(t[i])
		thash[byte(t[i])] = byte(s[i])
	}

	return true
}
*/

// records the first position of the byte
// this is fastest
/*
func isIsomorphic(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	var shash = make(map[byte]int)
	var thash = make(map[byte]int)

	for i := 0; i < len(s); i++ {
		spos, sok := shash[byte(s[i])]
		tpos, tok := thash[byte(t[i])]

		if sok != tok {
			return false
		}
		
		if sok == true {
			if spos != tpos {
				return false
			}

			continue
		}

		shash[byte(s[i])] = i
		thash[byte(t[i])] = i
	}

	return true
}*/

// shortest answer
func isIsomorphic(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	var shash = make(map[byte]int)
	var thash = make(map[byte]int)

	for i := 0; i < len(s); i++ {
		spos, sok := shash[byte(s[i])]
		tpos, tok := thash[byte(t[i])]

		if sok != tok || spos != tpos {
			return false
		}

		shash[byte(s[i])] = i
		thash[byte(t[i])] = i
	}

	return true
}


func main() {
	fmt.Println(isIsomorphic("add", "egg"))
	fmt.Println(isIsomorphic("foo", "bar"))
	fmt.Println(isIsomorphic("paper", "title"))
	fmt.Println(isIsomorphic("ab", "aa"))	
}
