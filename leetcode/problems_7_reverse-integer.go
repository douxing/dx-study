package main

import (
	"fmt"
)

func reverse (x int) int {
	var negative = false
	var origin int64
	if x < 0 {
		origin = -int64(x)
		negative = true
	} else {
		origin = int64(x)
	}

	var reverted int64 = 0
	var digit int64
	
	for origin > 0 {
		origin, digit = origin / 10, origin % 10
		reverted = reverted * 10 + digit
	}

	if negative {
		reverted = -reverted
	}

	if reverted < -2147483648 || reverted > 2147483647 {
		reverted = 0
	}

	return int(reverted)
}

func main () {
	fmt.Println(reverse(-111111111111111111))
}
