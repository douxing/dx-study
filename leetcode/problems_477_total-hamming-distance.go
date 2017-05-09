package main

import (
	"fmt"
)

// func hamming(left, right int) int {
// 	var result = left ^ right
// 	var count int = 0

// 	for result != 0 {
// 		count += result & 1
// 		result >>= 1
// 	}

// 	return count
// }

// func totalHammingDistance(nums []int) int {
// 	var total int = 0

// 	for i, a := range nums {
// 		for j := i + 1; j < len(nums); j++ {
// 			total += hamming(a, nums[j])
// 		}
// 	}

// 	return total
// }

func countone (ones []int, num int) {
	for index := 0; num != 0; index++ {
		ones[index] += num & 1
		num >>= 1
	}
}

func totalHammingDistance(nums []int) int {
	var ones []int = make([]int, 32)
	for _, num := range nums {
		countone(ones, num)
	}

	var total int = 0
	for _, count := range ones {
		total += count * (len(nums) - count)
	}
	return total
}

func main () {
	fmt.Println(totalHammingDistance([]int{4,14,2}))
}
