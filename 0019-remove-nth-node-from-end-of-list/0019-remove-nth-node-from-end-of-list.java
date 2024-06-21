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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer so that there is a gap of n nodes between first and second
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move both pointers to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Second pointer will be pointing to the node before the one to be deleted
        second.next = second.next.next;

        return dummy.next;
    }
}