class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // Create a dp array where dp[i][j] represents the minimum ASCII sum of deleted characters
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the dp array for the cases where one string is empty
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1); // Cost of deleting characters from s1
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1); // Cost of deleting characters from s2
        }

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Characters match, no cost to make equal
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Minimum cost of deleting either s1[i-1] or s2[j-1]
                    dp[i][j] = Math.min(
                        dp[i - 1][j] + s1.charAt(i - 1), // Delete from s1
                        dp[i][j - 1] + s2.charAt(j - 1)  // Delete from s2
                    );
                }
            }
        }

        // The answer is the cost to make s1[0...m-1] and s2[0...n-1] equal
        return dp[m][n];
    }
}
