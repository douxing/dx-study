package main

import (
	"fmt"
)

func findIandJ(nums1, nums2 []int) (i, j int) {
	// assert len(nums1) <= len(nums2)
	len1, len2 := len(nums1), len(nums2)
	half := (len1 + len2) / 2

	if nums1[len1 - 1] < nums2[0] {
		return len1, half - len1
	}
	
	// i within [0, len1 - 1] and j within [1, len2]
	// if i == 0 and len1 == len2, then j == len2
	left, right := 0, len1 - 1
	for left <= right {
		i = (left + right) / 2
		j = half - i // maybe len2

		if j == len2 {
			if nums1[i] < nums2[j - 1] {
				left = i + 1				
			} else {
				break
			}
		} else if nums1[i] < nums2[j] {
			if j - 1 >= 0 && nums1[i] < nums2[j - 1] {
				left = i + 1
			} else {
				break
			}
		} else if nums2[j] < nums1[i] {
			if i - 1 >= 0 && nums2[j] < nums1[i - 1] {
				right = i - 1
			} else {
				break
			}
		} else {
			break
		}
	}

	if left == len1 {
		i, j = len1, half - len1
	}

	return
}

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	if len(nums1) > len(nums2) {
		nums1, nums2 = nums2, nums1
	}

	len1, len2 := len(nums1), len(nums2)

	// assert len(nums1) <= len(nums2)
	if len(nums2) == 0 {
		panic("wrong input")
	} else if len(nums1) == 0 {
		return float64(nums2[(len2 - 1) / 2] + nums2[len2 / 2]) / 2
	}

	i, j := findIandJ(nums1, nums2)

	var min_of_biggers int

	if i < len1 && j < len2 {
		if nums1[i] < nums2[j] {
			min_of_biggers = nums1[i]
		} else {
			min_of_biggers = nums2[j]
		}
	} else if i < len1 {
		min_of_biggers = nums1[i]		
	} else if j < len2 {
		min_of_biggers = nums2[j]		
	}

	if (len1 + len2) % 2 == 1 {
		// fmt.Println(i, j, min_of_biggers)
		return float64(min_of_biggers)
	} else {
		var max_of_smallers int

		if i - 1 >= 0 && j - 1 >= 0 {
			if nums1[i - 1] > nums2[j - 1] {
				max_of_smallers = nums1[i - 1]
			} else {
				max_of_smallers = nums2[j - 1]
			}
		} else if i - 1 >= 0 {
			max_of_smallers = nums1[i - 1]		
		} else if j - 1 >= 0 {
			max_of_smallers = nums2[j - 1]
		}

		return float64(min_of_biggers + max_of_smallers) / 2
	}
}

func main() {
	fmt.Println(findMedianSortedArrays([]int{2}, []int{1,3,4,5}))
	fmt.Println(findMedianSortedArrays([]int{1, 3}, []int{2}))
	fmt.Println(findMedianSortedArrays([]int{1}, []int{1}))
	fmt.Println(findMedianSortedArrays([]int{1}, []int{2}))
	fmt.Println(findMedianSortedArrays([]int{3}, []int{2}))
	fmt.Println(findMedianSortedArrays([]int{1}, []int{2,3,4,5,6}))
	fmt.Println(findMedianSortedArrays([]int{1,6,7}, []int{2,3,4,5}))

	fmt.Println(findMedianSortedArrays([]int{1,1}, []int{1,2}))
}
