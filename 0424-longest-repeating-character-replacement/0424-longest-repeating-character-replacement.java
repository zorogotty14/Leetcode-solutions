class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];  // To store frequency of each character
        int maxCount = 0;  // Tracks the count of the most frequent character in the window
        int maxLength = 0;  // To store the maximum length of the valid window
        
        int left = 0;  // Left pointer of the sliding window
        
        // Iterate over the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // Increase the count of the current character
            count[s.charAt(right) - 'A']++;
            
            // Find the current maximum frequency character in the window
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            
            // The condition for a valid window is:
            // (window size - maxCount) should be <= k
            if (right - left + 1 - maxCount > k) {
                // If the window is invalid, shrink the window by moving the left pointer
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Update the maximum length of a valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
