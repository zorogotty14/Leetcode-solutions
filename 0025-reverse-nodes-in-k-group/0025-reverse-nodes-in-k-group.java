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
        ListNode current = dummy, prevGroupEnd = dummy;

        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode groupStart = current.next;
            ListNode check = current;
            for (int i = 0; i < k; i++) {
                check = check.next;
                if (check == null) {
                    return dummy.next;
                }
            }

            // Reverse k nodes
            ListNode prev = null, curr = groupStart, next = null;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect the reversed group to the previous part
            prevGroupEnd.next = prev;
            groupStart.next = curr;
            prevGroupEnd = groupStart;
            current = groupStart;
    }
    }
    
}