class Solution {
    public int change(int amount, int[] coins) {
        // Create a DP array with size amount + 1, initialized to 0
        int[] dp = new int[amount + 1];
        
        // Base case: there's 1 way to make up amount 0 (by using no coins)
        dp[0] = 1;
        
        // Iterate over each coin
        for (int coin : coins) {
            // Update the dp array for each amount from coin to amount
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        // The answer is stored in dp[amount], the number of ways to make the given amount
        return dp[amount];
    }
}
