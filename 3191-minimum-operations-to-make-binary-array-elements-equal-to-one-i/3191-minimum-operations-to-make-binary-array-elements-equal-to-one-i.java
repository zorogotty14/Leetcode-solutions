class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                // Flip nums[i], nums[i+1], nums[i+2]
                nums[i] ^= 1;
                nums[i+1] ^= 1;
                nums[i+2] ^= 1;
                operations++;
            }
        }

        // Check if all elements are 1
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return -1;  // Not possible to make all elements 1
            }
        }

        return operations;
    }
}
