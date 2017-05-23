package main

import (
	"fmt"
)

func findRepeatedDnaSequences(s string) []string {
	var history = make(map[uint32]bool)
	var result = make([]string, 0)

	// TODO: len(s) <= 10?

	var hash uint32 = 0;
	for i := 0; i < len(s); i++ {
		hash = (hash << 3 | (0x7 & uint32(s[i]))) & 0x3fffffff
		if marked, ok := history[hash]; ok && marked {
			continue
		} else if ok {
			result = append(result, s[i-9:i+1])
			history[hash] = true
		} else {
			history[hash] = false			
		}
	}

	return result
}

func main () {
	s := "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

	fmt.Println(findRepeatedDnaSequences(s))
}
