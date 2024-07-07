class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a 2D array to store the minimum edit distance
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the dp array
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // cost of deleting all characters from word1
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // cost of inserting all characters to word1
        }
        
        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no operation needed
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],  // replace
                               Math.min(dp[i - 1][j],  // delete
                                        dp[i][j - 1])  // insert
                               ) + 1;
                }
            }
        }
        
        // The answer is in the bottom-right corner of the dp array
        return dp[m][n];
    }
}