class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // Check if it's possible to find a valid subset sum
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) {
            return 0;
        }
        
        // Calculate the required subset sum P
        int P = (sum + target) / 2;
        
        // Use a DP array to solve the subset sum problem
        int[] dp = new int[P + 1];
        dp[0] = 1;  // There's one way to make the sum 0 (by choosing no elements)
        
        // Iterate through each number in nums
        for (int num : nums) {
            // Update the dp array from back to front
            for (int i = P; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        
        return dp[P];
    }
}
