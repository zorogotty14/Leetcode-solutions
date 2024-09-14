class Solution {
    public int splitArray(int[] nums, int k) {
        // Step 1: Determine the range for binary search
        int left = 0, right = 0;
        
        // left is the largest number in the array (minimum possible largest sum)
        // right is the sum of all numbers in the array (maximum possible largest sum)
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        // Step 2: Binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if we can split the array into k or fewer subarrays with max sum <= mid
            if (canSplit(nums, k, mid)) {
                right = mid; // Try to find a smaller max sum
            } else {
                left = mid + 1; // Increase mid to allow larger max sum
            }
        }

        return left;
    }

    // Helper function to determine if we can split the array into k or fewer subarrays
    // such that the sum of each subarray does not exceed `maxSum`.
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int subarrays = 1; // At least one subarray is needed

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                // If adding the current number exceeds maxSum, start a new subarray
                subarrays++;
                currentSum = num; // Start the new subarray with the current number
                if (subarrays > k) {
                    return false; // Too many subarrays, return false
                }
            } else {
                currentSum += num; // Otherwise, keep adding to the current subarray
            }
        }

        return true; // Can split into k or fewer subarrays
    }
}
