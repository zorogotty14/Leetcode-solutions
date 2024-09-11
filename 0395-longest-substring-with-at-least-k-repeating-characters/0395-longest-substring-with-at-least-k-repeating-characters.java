class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstringHelper(s, 0, s.length(), k);
    }
    
    private int longestSubstringHelper(String s, int start, int end, int k) {
        // Base case: if the string length is less than k, no valid substring can exist
        if (end - start < k) {
            return 0;
        }
        
        // Frequency array to count occurrences of each character
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Identify the "splitters" - characters with frequency less than k
        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                // Split at this character and apply the function recursively
                int left = longestSubstringHelper(s, start, i, k);
                int right = longestSubstringHelper(s, i + 1, end, k);
                return Math.max(left, right);
            }
        }
        
        // If we didn't split, it means the entire substring is valid
        return end - start;
    }
}
