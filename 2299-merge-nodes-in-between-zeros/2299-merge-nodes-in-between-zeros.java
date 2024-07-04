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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        
        ListNode current = head.next;  // Skip the first zero
        int sum = 0;

        while (current != null) {
            if (current.val == 0) {
                if (sum != 0) {
                    newHead.next = new ListNode(sum);
                    newHead = newHead.next;
                    sum = 0;
                }
            } else {
                sum += current.val;
            }
            current = current.next;
        }

        return dummy.next;
    }
}