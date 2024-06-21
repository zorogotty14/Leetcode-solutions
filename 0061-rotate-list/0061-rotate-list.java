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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Form a cycle
        current.next = head;

        // Calculate the effective rotations needed
        k = k % length;
        int stepsToNewHead = length - k;

        // Find the new tail and new head
        ListNode newTail = current;
        for (int i = 0; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Break the cycle
        newTail.next = null;

        return newHead;
    }
}