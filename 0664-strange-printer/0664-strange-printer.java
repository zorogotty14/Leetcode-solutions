class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = len;  // maximum turns needed is len
                for (int k = i; k < j; k++) {
                    int totalTurns = dp[i][k] + dp[k + 1][j];
                    if (s.charAt(i) == s.charAt(j)) {
                        totalTurns--;
                    }
                    dp[i][j] = Math.min(dp[i][j], totalTurns);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}