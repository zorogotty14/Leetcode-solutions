class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // Edge case
        if (m < n) {
            return 0;
        }
        
        // dp[i][j] will be storing the count of distinct subsequences of s[0..i-1] which equals t[0..j-1].
        int[][] dp = new int[m + 1][n + 1];
        
        // Initializing first column, as any string has exactly one subsequence which is an empty string.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // The answer will be in dp[m][n]
        return dp[m][n];
    }
}