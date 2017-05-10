package main

import (
	"fmt"
)

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}


//// a concise version:
//// https://discuss.leetcode.com/topic/7427/a-very-concise-solution/2
func postorderTraversal(root *TreeNode) []int {
	var nodestack []*TreeNode = make([]*TreeNode, 0)
	var lrstack []string = make([]string, 0)
	var node *TreeNode = root
	var lr string
	var stacklen int

	var result []int = make([]int, 0)
	if root == nil {
		return result
	}
L:	
	for {
		if node.Left != nil {
			nodestack = append(nodestack, node)
			lrstack = append(lrstack, "l")

			node = node.Left
		} else if node.Right != nil {
			nodestack = append(nodestack, node)
			lrstack = append(lrstack, "r")

			node = node.Right
		} else {
			result = append(result, node.Val)
			
			// nodestack and lrstack has the same length
			stacklen = len(nodestack)
			if stacklen == 0 {
				break L
			}
			node, lr = nodestack[stacklen - 1], lrstack[stacklen - 1]
			nodestack, lrstack = nodestack[:stacklen - 1], lrstack[:stacklen - 1]

			for {
				if lr == "l" && node.Right != nil {
					nodestack = append(nodestack, node)
					lrstack = append(lrstack, "r")

					node = node.Right
					break
				} else {
					// lr == "r" || (lr == "l" && node.Right == nil)
					result = append(result, node.Val)
					
					// nodestack and lrstack has the same length
					stacklen = len(nodestack)
					if stacklen == 0 {
						break L
					}

					node, lr = nodestack[stacklen - 1], lrstack[stacklen - 1]
					nodestack, lrstack = nodestack[:stacklen - 1], lrstack[:stacklen - 1]
				}
			}
		}
	}

	return result
}

func main () {
	var root *TreeNode = &TreeNode{1, nil, nil}
	root.Right = &TreeNode{2, nil, nil}
	var result = postorderTraversal(root)

	fmt.Println("", result)
}
