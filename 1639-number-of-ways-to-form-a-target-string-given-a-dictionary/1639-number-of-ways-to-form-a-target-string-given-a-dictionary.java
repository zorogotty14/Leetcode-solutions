class Solution {
    public int numWays(String[] words, String target) {
        // Modulo constant
        final int MOD = 1_000_000_007;
        
        int n = words.length;       // Number of words
        int m = words[0].length();  // Length of each word (all are the same)
        int t = target.length();    // Length of target
        
        // Step 1: Build frequency array: freq[col][char]
        // freq[c][ch] = number of words whose c-th character == ch
        long[][] freq = new long[m][26];
        for (int j = 0; j < n; j++) {
            String w = words[j];
            for (int c = 0; c < m; c++) {
                freq[c][w.charAt(c) - 'a']++;
            }
        }
        
        // Step 2: DP array to count ways to form target prefix
        // dp[i] = number of ways to form target[0..i-1]
        long[] dp = new long[t + 1];
        dp[0] = 1;  // base case: one way to form empty prefix
        
        // Step 3: For each column, update dp in descending order of target index
        for (int col = 0; col < m; col++) {
            // Iterate backwards to ensure we don't reuse updated dp values in the same column
            for (int i = t - 1; i >= 0; i--) {
                char ch = target.charAt(i);
                // If freq for this character in the current column > 0, update dp
                long count = freq[col][ch - 'a'];
                if (count > 0) {
                    dp[i + 1] = (dp[i + 1] + (dp[i] * count) % MOD) % MOD;
                }
            }
        }
        
        // dp[t] is the number of ways to form the entire target
        return (int) dp[t];
    }
}
