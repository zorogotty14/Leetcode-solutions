class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first k elements
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        // Initialize maxSum with the sum of the first window
        double maxSum = currentSum;

        // Use sliding window to find the maximum sum of any k-length subarray
        for (int i = k; i < nums.length; i++) {
            // Slide the window: remove the element going out, add the new element
            currentSum = currentSum - nums[i - k] + nums[i];
            // Update maxSum if currentSum is larger
            maxSum = Math.max(maxSum, currentSum);
        }

        // Return the maximum average
        return maxSum / k;
    }
}
