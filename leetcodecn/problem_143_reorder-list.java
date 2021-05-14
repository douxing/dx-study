/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            len += 1;
        }
        if (len == 0 || len == 1) return;

        ListNode[] l = new ListNode[len];
        ptr = head;
        for (int i = 0; i < len; i += 1) {
            l[i] = ptr;
            ptr = ptr.next;
        }

        int left = 0;
        int right = len - 1;
        while (true) {
            l[left].next = l[right];
            left += 1;
            if (left == right) {
                l[left].next = null;
                break;
            }
            l[right].next = l[left];
            right -= 1;
            if (left == right) {
                l[right].next = null;
                break;
            }
        }
    }
}
