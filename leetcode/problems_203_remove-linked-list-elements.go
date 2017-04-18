package main

import (
	"fmt"
)

/**
 * Definition for singly-linked list.
 */

type ListNode struct {
	Val int
	Next *ListNode
}

func removeElements(head *ListNode, val int) *ListNode {
	if head == nil {
		return nil
	}

	for {
		if head != nil && head.Val == val {
			head = head.Next
		} else {
			break
		}
	}

	if head == nil {
		return nil
	}

	current := head

	for current.Next != nil {
		if current.Next.Val == val {
			current.Next = current.Next.Next
		} else {
			current = current.Next
		}
	}

	return head
}

func main () {
	var head *ListNode = &ListNode{
		Val: 1,
		Next: nil,
	}
	var current *ListNode = head

	for _, val := range([]int{2,6,3,4,5,6}) {
		current.Next = &ListNode{
			Val: val,
			Next: nil,
		}

		current = current.Next
	}
	current = removeElements(head, 6)

	for current != nil {
		fmt.Printf("%d, ", current.Val)
		current = current.Next
	}
}
