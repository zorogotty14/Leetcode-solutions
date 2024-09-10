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
import java.util.*;


class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Check if the list is too short to insert any new nodes
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        
        // Traverse through the linked list
        while (curr != null && curr.next != null) {
            int gcdValue = gcd(curr.val, curr.next.val);  // Calculate GCD of current node and next node
            
            // Insert a new node with the GCD value
            ListNode newNode = new ListNode(gcdValue);
            newNode.next = curr.next;  // Link the new node to the next node
            curr.next = newNode;  // Link the current node to the new node
            
            curr = newNode.next;  // Move to the next pair
        }
        
        return head;
    }
    
    // Helper method to calculate GCD of two numbers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
