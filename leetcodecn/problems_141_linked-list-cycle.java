/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        while (head != null) {
            if (head.val == 100001) {
                return true;
            } else {
                head.val = 100001;
                head = head.next;
            }
        }
        return false;
    }


    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast =  fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;
    }
}
