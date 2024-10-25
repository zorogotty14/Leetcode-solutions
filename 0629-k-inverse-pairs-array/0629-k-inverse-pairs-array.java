class Solution {
    private static final int MOD = 1_000_000_007;

    public int kInversePairs(int n, int k) {
        // Create a 2D DP table with size (n + 1) x (k + 1)
        int[][] dp = new int[n + 1][k + 1];

        // Base case: dp[i][0] = 1 (only one way to arrange elements with 0 inverse pairs)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // Use prefix sum to optimize the computation
                dp[i][j] = dp[i - 1][j]; // Take all ways without the current element
                
                if (j >= i) {
                    // Subtract the cases where adding the current element introduces too many inverse pairs
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + MOD) % MOD;
                }

                // Accumulate the prefix sum
                dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }

        // The answer is the number of ways to arrange `n` elements with exactly `k` inverse pairs
        return dp[n][k];
    }
}
