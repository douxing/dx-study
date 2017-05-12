package main

import (
	"fmt"
)

func isHappy(n int) bool {
	if n < 1 {
		return false
	}

	container := make(map[int]interface{})
	for {
		if n == 1 {
			return true
		} else if _, ok := container[n]; ok {
			return false
		}

		container[n] = nil

		sum := 0
		for n != 0 {
			sum += (n % 10) * (n % 10)
			n /= 10
		}
		n = sum
	}
}

func main () {
	fmt.Println("isOkay: ", isHappy(91))
}
