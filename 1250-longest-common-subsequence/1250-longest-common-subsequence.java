class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            return longestCommonSubsequence(text2, text1); // Ensure text1 is the longer string
        }
        
        int m = text1.length();
        int k = text2.length();
        
        // dp array to store the current and previous rows
        int[] dp = new int[k + 1];
        
        for (int i = 1; i <= m; i++) {
            int[] newDp = new int[k + 1];
            for (int j = 1; j <= k; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    newDp[j] = dp[j - 1] + 1;
                } else {
                    newDp[j] = Math.max(dp[j], newDp[j - 1]);
                }
            }
            dp = newDp;
        }
        
        return dp[k];
    }
}