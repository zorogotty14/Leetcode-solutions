class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currentMin = 0;

        for (int num : nums) {
            totalSum += num;

            // Kadane's algorithm to find the maximum subarray sum
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's algorithm to find the minimum subarray sum
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all elements are negative, maxSum will be the largest element
        // Hence, return maxSum in this case
        if (maxSum < 0) {
            return maxSum;
        }

        // Otherwise, return the maximum of maxSum and (totalSum - minSum)
        return Math.max(maxSum, totalSum - minSum);
    }
}