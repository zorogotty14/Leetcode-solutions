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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        
        List<Integer> criticalPoints = new ArrayList<>();
        int index = 1;  // Start with the second node
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) || 
                (curr.val < prev.val && curr.val < next.val)) {
                criticalPoints.add(index);
            }
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }
        
        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }
        
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
        
        for (int i = 1; i < criticalPoints.size(); i++) {
            int distance = criticalPoints.get(i) - criticalPoints.get(i - 1);
            minDistance = Math.min(minDistance, distance);
        }
        
        return new int[]{minDistance, maxDistance};
    }
}