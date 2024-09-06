import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Convert the nums array to a set for fast lookup
        Set<Integer> toRemove = new HashSet<>();
        for (int num : nums) {
            toRemove.add(num);
        }

        // Create a dummy node to handle edge cases where the head might be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use two pointers: prev (starts from dummy) and curr (starts from head)
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (toRemove.contains(curr.val)) {
                // Skip the current node by linking prev to curr.next
                prev.next = curr.next;
            } else {
                // Move prev forward only if we did not skip the current node
                prev = curr;
            }
            // Move curr to the next node
            curr = curr.next;
        }

        // Return the updated linked list starting from dummy.next
        return dummy.next;
    }
}
