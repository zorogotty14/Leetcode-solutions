class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        
        // dp[i] stores the length of the longest valid subsequence ending at index i
        int[] dp = new int[n];
        // prev[i] stores the previous index in the optimal subsequence ending at i
        int[] prev = new int[n];
        
        // Initialize dp and prev arrays
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int maxLength = 1;
        int endIndex = 0;
        
        // Build dp array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if this pair satisfies the conditions
                if (isValidPair(words[j], words[i]) && groups[j] != groups[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                    
                    // Update the maximum length and its end index
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }
        
        // Reconstruct the subsequence
        List<String> result = new ArrayList<>();
        while (endIndex != -1) {
            result.add(words[endIndex]);
            endIndex = prev[endIndex];
        }
        
        // Reverse the result since we built it backwards
        Collections.reverse(result);
        return result;
    }
    
    // Helper method to check if two strings have the same length and a hamming distance of 1
    private boolean isValidPair(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        
        return diffCount == 1;
    }
}