class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum_k = new int[n - k + 1];
        
        // Step 1: Calculate the sum of each subarray of length k
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            if (i >= k) {
                currentSum -= nums[i - k];
            }
            if (i >= k - 1) {
                sum_k[i - k + 1] = currentSum;
            }
        }
        
        // Step 2: Calculate the best left index for each position
        int[] left = new int[sum_k.length];
        int bestLeftIdx = 0;
        for (int i = 0; i < sum_k.length; i++) {
            if (sum_k[i] > sum_k[bestLeftIdx]) {
                bestLeftIdx = i;
            }
            left[i] = bestLeftIdx;
        }
        
        // Step 3: Calculate the best right index for each position
        int[] right = new int[sum_k.length];
        int bestRightIdx = sum_k.length - 1;
        for (int i = sum_k.length - 1; i >= 0; i--) {
            if (sum_k[i] >= sum_k[bestRightIdx]) {
                bestRightIdx = i;
            }
            right[i] = bestRightIdx;
        }
        
        // Step 4: Find the maximum sum by trying every possible middle subarray
        int maxSum = 0;
        int[] result = new int[3];
        for (int j = k; j <= n - 2 * k; j++) {
            int i = left[j - k];
            int l = right[j + k];
            int totalSum = sum_k[i] + sum_k[j] + sum_k[l];
            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = i;
                result[1] = j;
                result[2] = l;
            }
        }
        
        return result;
    }
}
