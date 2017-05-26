package main

import (
	"fmt"
)

func intersect(nums1 []int, nums2 []int) []int {
	set1 := make(map[int]int)
	result := make([]int, 0)

	for _, i := range nums1 {
		if _, ok := set1[i]; ok {
			set1[i]++
		} else {
			set1[i] = 1
		}
	}

	for _, i := range nums2 {
		if count, ok := set1[i]; ok && count > 0 {
			result = append(result, i)
			set1[i]--
		}
	}

	return result
}

func main() {
	fmt.Println(intersection([]int{1,2,2,2,2,34,5}, []int{1,2,3,4,5,2}))
}
