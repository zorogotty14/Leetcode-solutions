class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] sum_piles = new int[n];
        
        sum_piles[n-1] = piles[n-1];
        for (int i = n - 2; i >= 0; i--) {
            sum_piles[i] = sum_piles[i + 1] + piles[i];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {
                if (i + 2 * M >= n) {
                    dp[i][M] = sum_piles[i];
                } else {
                    for (int X = 1; X <= 2 * M; X++) {
                        dp[i][M] = Math.max(dp[i][M], sum_piles[i] - dp[i + X][Math.max(M, X)]);
                    }
                }
            }
        }
        
        return dp[0][1];
    }
}
