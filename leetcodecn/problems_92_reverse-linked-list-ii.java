class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
	ListNode zeroNode = new ListNode(0);
	zeroNode.next = head;
	int index = 0;
	ListNode l = zeroNode;
	while (index + 1 < left) {
	    l = l.next;
	    index += 1;
	}
	
	ListNode t1 = l.next;  // already re-ordered
	ListNode t2 = t1.next; // bo be re-ordered
	ListNode t3;
	while (index + 1 < right) {
	    // before:
	    //         t1   t2    t3
	    // .....<-NODE NODE->NODE.....
	    // after:
	    //               t1   t2
	    // .....<-NODE<-NODE NODE.....
	    t3 = t2.next;
	    t2.next = t1;
	    t1 = t2;
	    t2 = t3;
	    index += 1;
	}
	l.next.next = t2;
	l.next = t1;

	return zeroNode.next;
    }
}
