class Solution {
    public int getMoneyAmount(int n) {
        // dp[i][j] represents the minimum cost to guarantee a win in the range [i, j]
        int[][] dp = new int[n + 1][n + 1];
        
        // Iterate over the lengths of intervals
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                // Try every possible k in the range [i, j]
                for (int k = i; k <= j; k++) {
                    // The cost is the worst-case scenario: guessing k costs k dollars,
                    // and we also have to consider the cost of solving the smaller ranges
                    // [i, k-1] and [k+1, j]
                    int cost = k + Math.max(k - 1 >= i ? dp[i][k - 1] : 0, k + 1 <= j ? dp[k + 1][j] : 0);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        // The answer for the full range [1, n] is stored in dp[1][n]
        return dp[1][n];
    }
}
