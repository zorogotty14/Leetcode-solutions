import java.util.HashSet;

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        // Step 1: Add all nums elements to a HashSet for fast lookup
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // Step 2: Traverse the linked list and count components
        int components = 0;
        boolean inComponent = false;

        while (head != null) {
            if (numSet.contains(head.val)) {
                if (!inComponent) {
                    // Start of a new component
                    components++;
                    inComponent = true;
                }
            } else {
                // End of a component
                inComponent = false;
            }
            head = head.next;
        }

        return components;
    }
}
