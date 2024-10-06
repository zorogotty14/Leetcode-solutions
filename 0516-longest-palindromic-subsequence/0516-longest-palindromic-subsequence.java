class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // DP table to store results of subproblems
        int[][] dp = new int[n][n];
        
        // Base case: every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        // Fill the DP table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The result is in dp[0][n-1], the longest palindromic subsequence in the entire string
        return dp[0][n - 1];
    }
}
