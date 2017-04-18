package main

import (
	"fmt"
)

func findPeakElement(nums []int) int {
	var length = len(nums)
	for index := 0; index < length; index++ {
		if index + 1 < length && nums[index] > nums[index + 1] {
			return index
		}
	}

	return length - 1 // rarely here
}

func main () {
	fmt.Println(findPeakElement([]int{1,2,3,1}))
}
