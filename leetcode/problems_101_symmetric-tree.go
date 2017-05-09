package main

import (
	// "fmt"
)


//  Definition for a binary tree node.
type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func recursivelyParse (left, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	} else if left == nil || right == nil {
		return false
	} else if left.Val != right.Val {
		return false
	}

	return recursivelyParse(left.Left, right.Right) &&
		recursivelyParse(left.Right, right.Left)
}

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	} 

	return recursivelyParse(root.Left, root.Right)
}

func main () {
}
