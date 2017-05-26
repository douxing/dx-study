package main

import (
	"fmt"
)

func intersection(nums1 []int, nums2 []int) []int {
	set1 := make(map[int]int)
	set2 := make(map[int]int)
	result := make([]int, 0)

	for _, i := range nums1 {
		set1[i] = i
	}

	for _, i := range nums2 {
		if _, ok := set1[i]; ok {
			set2[i] = i
		}
	}

	for i, _ := range set2 {
		result = append(result, i)
	}

	return result
}

func main() {
	fmt.Println(intersection([]int{1,2,2,2,2,34,5}, []int{1,2,3,4,5}))
}
