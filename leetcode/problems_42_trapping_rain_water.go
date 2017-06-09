package main

import (
	"fmt"
)

func trap(height []int) int {
    left, right := 0, len(height) - 1
	leftmax, rightmax := 0, 0
	result := 0
	
	
	for left <= right {
		if height[left] < height[right] {
			if leftmax < height[left] {
				leftmax = height[left]
			}

			result += leftmax - height[left]
			left++
		} else {
			if rightmax < height[right] {
				rightmax = height[right]
			}

			result += rightmax - height[right]
			right--
		}
	}

	return result
}

func main() {
	fmt.Println(trap([]int{0,1,0,2,1,0,1,3,2,1,2,1}))
}
