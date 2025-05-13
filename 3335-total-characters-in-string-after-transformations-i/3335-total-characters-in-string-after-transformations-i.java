class Solution {
    public int lengthAfterTransformations(String s, int t) {
        // Modulo constant
        final int MOD = 1_000_000_007;
        
        // Initialize character counts
        long[] counts = new long[26]; // counts[0] = count of 'a', counts[1] = count of 'b', etc.
        
        // Count initial characters
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        
        // For each transformation
        for (int i = 0; i < t; i++) {
            long[] newCounts = new long[26];
            
            // Process each character type
            for (int j = 0; j < 26; j++) {
                if (j == 25) { // 'z'
                    // 'z' becomes "ab"
                    newCounts[0] = (newCounts[0] + counts[j]) % MOD; // 'a'
                    newCounts[1] = (newCounts[1] + counts[j]) % MOD; // 'b'
                } else {
                    // Regular character becomes next character
                    newCounts[j + 1] = (newCounts[j + 1] + counts[j]) % MOD;
                }
            }
            
            // Update counts for next iteration
            counts = newCounts;
        }
        
        // Calculate total length
        long totalLength = 0;
        for (long count : counts) {
            totalLength = (totalLength + count) % MOD;
        }
        
        return (int) totalLength;
    }
}