package main

import (
	"fmt"
)

func singleNonDuplicate(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	// assert len(nums) >= 3

	left := 0
	right := len(nums) - 1
	index := 0

	if nums[0] != nums[1] {
		return nums[0]
	} else if nums[len(nums) - 1] != nums[len(nums) - 2] {
		return nums[len(nums) - 1]
	}

	for left <= right {
		index = (left + right) / 2
		if nums[index - 1] == nums[index] {
			if index % 2 == 0 {
				right = index - 2
			} else {
				left = index + 1
			}
		} else if nums[index] == nums[index + 1] {
			if index % 2 == 0 {
				left = index + 2
			} else {
				right = index - 1
			}
		} else {
			break
		}
	}

	return nums[index]
}

func main() {
	fmt.Println(singleNonDuplicate([]int{1,1,2}))
}
