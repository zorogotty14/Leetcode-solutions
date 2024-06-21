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
        ListNode current = head, prevGroupEnd = dummy;

        while (current != null) {
            // Check if there are at least k nodes left to reverse
            ListNode groupStart = current;
            int count = 0;
            while (count < k && current != null) {
                current = current.next;
                count++;
            }
            if (count == k) {
                // Reverse k nodes
                ListNode reversedGroup = reverse(groupStart, k);
                prevGroupEnd.next = reversedGroup;
                prevGroupEnd = groupStart;
            } else {
                // Less than k nodes left, no more reversals needed
                prevGroupEnd.next = groupStart;
            }
        }

        return dummy.next;
    }
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null, current = head, next = null;
        while (k > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }
        return prev;
    }
}