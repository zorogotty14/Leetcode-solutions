class Solution {
    // Helper function to calculate the next index in the circular array
    private int next(int index, int[] nums) {
        int n = nums.length;
        return ((index + nums[index]) % n + n) % n;  // ensures it's within bounds
    }

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;  // Skip already visited elements
            
            // Initialize slow and fast pointers
            int slow = i, fast = i;
            boolean isForward = nums[i] > 0;  // Determine the direction (positive or negative)
            
            // Iterate using the slow and fast pointer technique
            while (true) {
                // Move slow pointer one step
                slow = next(slow, nums);
                // Move fast pointer two steps
                fast = next(fast, nums);
                if (nums[fast] == 0 || (nums[fast] > 0) != isForward) break;
                fast = next(fast, nums);
                
                // Check if slow meets fast (cycle found)
                if (slow == fast) {
                    // Ensure the cycle is longer than 1 element (i.e., it doesn't just point to itself)
                    if (slow != next(slow, nums)) return true;
                    else break;
                }
                
                // If the direction changes or we hit a visited element, exit the loop
                if ((nums[slow] > 0) != isForward || nums[slow] == 0) break;
            }
            
            // Mark all elements in the current cycle as 0 to avoid revisiting
            slow = i;
            int val = nums[i];
            while ((nums[slow] > 0) == isForward && nums[slow] != 0) {
                int nextIndex = next(slow, nums);
                nums[slow] = 0;  // Mark as visited
                slow = nextIndex;
            }
        }

        return false;  // No valid cycle found
    }
}
