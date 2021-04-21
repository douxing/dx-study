package leetcode;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
	boolean dup = false;
	while (head != null && head.next != null) {
	    if (head.val == head.next.val) {
		head = head.next;
		dup = true;
	    } else if (dup) {
		head = head.next;
		dup = false;
	    } else {
		break;
	    }
	}

	if (dup) {
	    head = head.next;
	}
	if (head == null) {
	    return null; 
	}

	ListNode n = head;
	dup = false;
	while (n.next != null && n.next.next != null) {
	    if (n.next.val == n.next.next.val) {
		n.next = n.next.next;
		dup = true;
	    } else if (dup) {
		n.next = n.next.next;
		dup = false;
	    } else {
		n = n.next;
	    }
	}
	if (dup) {
	    n.next = null;
	}

	return head;
    }
}
