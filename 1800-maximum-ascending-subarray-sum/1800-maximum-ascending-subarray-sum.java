class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];  // Initialize max sum with first element
        int currentSum = nums[0];  // Initialize current sum for tracking ascending subarrays

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // Continue the ascending subarray
                currentSum += nums[i];
            } else {
                // Reset the current sum for a new subarray
                maxSum = Math.max(maxSum, currentSum);
                currentSum = nums[i];
            }
        }

        // Final comparison to ensure we consider the last subarray
        return Math.max(maxSum, currentSum);
    }
}
