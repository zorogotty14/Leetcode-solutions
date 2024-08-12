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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        // Dummy node as the new head of the sorted list
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        
        while (current != null) {
            // At each iteration, we are going to insert `current` into the sorted part
            ListNode prev = dummy;  // Start from the dummy node
            ListNode next = current.next;  // Keep track of the next node to process
            
            // Find the right place to insert the current node
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            
            // Insert the current node into the sorted list
            current.next = prev.next;
            prev.next = current;
            
            // Move to the next node in the original list
            current = next;
        }
        
        // The sorted list is after the dummy node
        return dummy.next;
    }
}