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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node initialization to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy, next = dummy, prev = dummy;
        int count = 0;

        // Count the number of nodes in the list
        while (current.next != null) {
            current = current.next;
            count++;
        }

        // Reverse in groups of k
        while (count >= k) {
            current = prev.next;
            next = current.next;
            for (int i = 1; i < k; i++) {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            prev = current;
            count -= k;
        }

        return dummy.next;
    }
}