class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // DP array to store the maximum number of strings that can be formed with i 0's and j 1's
        int[][] dp = new int[m + 1][n + 1];
        
        // Iterate over each string in strs
        for (String str : strs) {
            // Count number of 0's and 1's in the current string
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            
            // Update the dp table from bottom-right to top-left
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        
        // The answer is in dp[m][n]
        return dp[m][n];
    }
}
