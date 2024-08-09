/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // If they meet, there is a cycle
            if (slow == fast) {
                break;
            }
        }
        
        // If no cycle was detected
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // Step 2: Find the start of the cycle
        ListNode start = head;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }
        
        // The node where both pointers meet is the start of the cycle
        return start;
    }
}