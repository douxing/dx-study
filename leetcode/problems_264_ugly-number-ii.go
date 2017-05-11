package main

import (
	"fmt"
)

func nthUglyNumber(n int) int {
	history := []int{1}
	in2, in3, in5 := 0, 0, 0
    
	for index := 1; index < n; index++ {
		lowest := history[in2] * 2
		if lowest > history[in3] * 3 {
			lowest = history[in3] * 3
		}
		if lowest > history[in5] * 5 {
			lowest = history[in5] * 5
		}

		if history[in2] * 2 == lowest {
			in2++
		}
		if history[in3] * 3 == lowest {
			in3++
		}
		if history[in5] * 5 == lowest {
			in5++
		}
		history = append(history, lowest)
	}

	return history[n - 1]
}

func main () {
	for index := 1; index < 20; index++ {
		fmt.Println(nthUglyNumber(index))
	}
//	nthUglyNumber(20)
}
