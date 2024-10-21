class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // DP table to store LCS lengths
        int[][] dp = new int[m + 1][n + 1];

        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // If characters match, increase LCS length
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // Take the max of excluding one character
                }
            }
        }

        // Length of the longest common subsequence
        int lcsLen = dp[m][n];

        // Minimum deletions required
        return (m - lcsLen) + (n - lcsLen);
    }
}
