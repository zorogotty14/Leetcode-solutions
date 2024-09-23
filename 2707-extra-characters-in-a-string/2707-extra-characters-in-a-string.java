import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        // Convert dictionary array into a set for faster lookup
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }
        
        int n = s.length();
        // DP array to store the minimum extra characters for each index
        int[] dp = new int[n + 1];
        
        // Initialize dp array with the worst case (i.e., every character is extra)
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        
        // Iterate over the string
        for (int i = 0; i < n; i++) {
            // For each index i, try to find a substring that matches a word in the dictionary
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (dict.contains(substring)) {
                    // If the substring matches, update the dp value
                    dp[j] = Math.min(dp[j], dp[i]);
                }
            }
            // Update dp[i+1] assuming current character is extra
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }
        
        // The answer is the minimum extra characters left at the end of the string
        return dp[n];
    }
}
