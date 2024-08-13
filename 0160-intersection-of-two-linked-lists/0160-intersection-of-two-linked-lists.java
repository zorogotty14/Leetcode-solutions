/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either of the heads is null, there can't be any intersection
        if (headA == null || headB == null) {
            return null;
        }
        
        // Initialize two pointers, one for each list
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        
        // Traverse both lists, switch to the other list when the end is reached
        while (pointerA != pointerB) {
            // If pointerA reaches the end of listA, redirect it to the start of listB
            pointerA = (pointerA == null) ? headB : pointerA.next;
            
            // If pointerB reaches the end of listB, redirect it to the start of listA
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        
        // If the lists intersect, pointerA and pointerB will eventually meet at the intersection node.
        // If the lists do not intersect, both pointers will be null.
        return pointerA;
    }
}