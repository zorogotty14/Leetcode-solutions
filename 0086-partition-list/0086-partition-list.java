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
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes to start the less and greater lists
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);
        
        // Pointers to the current end of the less and greater lists
        ListNode less = lessDummy;
        ListNode greater = greaterDummy;
        
        // Traverse the original list and partition the nodes
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        
        // Terminate the greater list
        greater.next = null;
        
        // Connect the less list to the greater list
        less.next = greaterDummy.next;
        
        // Return the head of the less list (skip the dummy node)
        return lessDummy.next;
    }
}