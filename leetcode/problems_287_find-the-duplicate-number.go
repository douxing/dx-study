package main

import (
	"fmt"
)

func findDuplicate(nums []int) int {
	var slow, fast = nums[0], nums[nums[0]]
	
	for nums[slow] != nums[fast] {
		slow, fast = nums[slow], nums[nums[fast]]
	}

	fast = 0

	for nums[slow] != nums[fast] {
		slow, fast = nums[slow], nums[fast]
	}

	return nums[slow]
}

func main() {
	fmt.Println(findDuplicate([]int{1,2,3,4,5,6,7,8,9,10,9}))
}
