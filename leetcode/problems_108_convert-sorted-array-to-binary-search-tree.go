/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedArrayToBST(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}

	var mid = len(nums) / 2

	var root = &TreeNode{
		Val: nums[mid],
		Left: sortedArrayToBST(nums[0:mid]),
		Right: sortedArrayToBST(nums[mid+1:len(nums)]),
	}

	return root
}

func main () {
	var root *TreeNode
	var nums = []int{1,2,3,4,5,6,7}
	root = sortedArrayToBST(nums)

	fmt.Println("done", root.Val)
}
