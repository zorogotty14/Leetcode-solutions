class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // If there are only two steps, return the minimum of the two
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }

        // DP array to store the minimum cost to reach each step
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Fill the DP array
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // Return the minimum cost to reach the top (either from the last or second-last step)
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
