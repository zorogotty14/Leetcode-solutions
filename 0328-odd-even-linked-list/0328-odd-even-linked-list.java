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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Keep the head of the even list to link later
        
        while (even != null && even.next != null) {
            odd.next = even.next;  // Link the next odd node
            odd = odd.next;        // Move the odd pointer
            
            even.next = odd.next;  // Link the next even node
            even = even.next;      // Move the even pointer
        }
        
        odd.next = evenHead; // Connect odd list with the even list
        return head;
    }
}