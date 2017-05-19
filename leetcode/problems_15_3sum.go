package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
	result := make([][]int, 0, len(nums))
	sort.Sort(sort.IntSlice(nums))

	for index := 0; index < len(nums) - 2; index++ {
		if index != 0 && nums[index] == nums[index - 1] {
			continue
		}

		var lindex, rindex = index + 1, len(nums) - 1

		for lindex < rindex {
			if nums[lindex] + nums[rindex] + nums[index] == 0 {
				// found
				result = append(result, []int{nums[index], nums[lindex], nums[rindex]})
				for lindex < rindex && nums[lindex] == nums[lindex+1] {
					lindex++
				}
				for lindex < rindex && nums[lindex] == nums[lindex+1] {
					rindex++
				}				
				lindex++
				rindex--
			} else if nums[lindex] + nums[rindex] + nums[index] < 0 {
				lindex++
			} else {
				// nums[lindex] + nums[rindex] + nums[index] > 0
				rindex--
			}	
		}
	}

	return result
}

func main () {
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4}))
	fmt.Println(threeSum([]int{-2, 0, 0, 2, 2}))
}
