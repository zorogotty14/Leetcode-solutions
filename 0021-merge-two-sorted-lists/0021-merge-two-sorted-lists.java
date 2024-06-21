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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Edge cases when one of the lists is empty
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        // Initialize the head of the merged list
        ListNode head = null;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        
        // Current pointer to track the merged list
        ListNode current = head;
        
        // Merge the lists by updating pointers in-place
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // Attach the remaining nodes from either list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        return head;
    }
}