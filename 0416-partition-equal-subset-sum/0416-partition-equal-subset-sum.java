class Solution {
    public boolean canPartition(int[] nums) {
        // Step 1: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Step 2: If the total sum is odd, we cannot partition it into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }
        
        // Step 3: Define the target sum (half of the total sum)
        int target = totalSum / 2;
        
        // Step 4: Initialize a boolean DP array where dp[i] means we can form a subset with sum i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // We can always form a sum of 0 (with an empty subset)
        
        // Step 5: Process each number in the nums array
        for (int num : nums) {
            // Traverse the dp array from the back to avoid using the same number multiple times
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        // Step 6: The answer is whether we can form a subset with sum equal to target
        return dp[target];
    }
}
