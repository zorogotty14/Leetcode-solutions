class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] dp;

    private int solve(int k, int i, int j, int n, int minProfit, int[] group, int[] profit) {
        if (k == profit.length) {
            if (j >= minProfit && n >= i) return 1;
            return 0;
        } else if (n < i) {
            return 0;
        }

        if (dp[k][i][j] != -1) return dp[k][i][j];

        int notInclude = solve(k + 1, i, j, n, minProfit, group, profit);
        int include = 0;
        if (i + group[k] <= n) {
            include = solve(k + 1, i + group[k], Math.min(j + profit[k], minProfit), n, minProfit, group, profit);
        }

        return dp[k][i][j] = (include % MOD + notInclude % MOD) % MOD;
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new int[group.length + 1][n + 1][minProfit + 1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, 0, n, minProfit, group, profit);
    }
}
