class Solution {
    public int combinationSum4(int[] nums, int target) {
        // Step 1: Create the dp array of size (target + 1)
        int[] dp = new int[target + 1];
        
        // Step 2: Base case: there is one way to get target 0 (using no numbers)
        dp[0] = 1;
        
        // Step 3: Fill the dp array
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        // Step 4: Return the number of ways to form the target sum
        return dp[target];
    }
}
