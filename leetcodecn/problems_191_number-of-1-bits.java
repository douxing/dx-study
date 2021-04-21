package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
    public int hammingWeight(int n) {
	int res=0;
	int a=32;
	while(a!=0){
	    res+=n&1;
	    n=n>>1;
	    a--;
	}
	return res;
    }
    */

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
	int c = 0;
	if (n < 0) {
	    n &= Integer.MAX_VALUE;
	    c = 1;
	}

        while (n != 0) {
            c += n % 2;
            n >>>= 1;
        }

        return c;
    }
}
