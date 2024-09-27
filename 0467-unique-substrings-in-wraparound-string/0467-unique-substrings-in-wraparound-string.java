class Solution {
    public int findSubstringInWraproundString(String s) {
        // Array to store the max length of substring ending with each letter
        int[] dp = new int[26]; // dp[i] represents max substrings ending with 'a' + i
        
        int maxLength = 0; // Current length of consecutive substring following wraparound order
        
        for (int i = 0; i < s.length(); i++) {
            // Check if current character and previous one are consecutive in the alphabet (wraparound)
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || (s.charAt(i - 1) == 'z' && s.charAt(i) == 'a'))) {
                maxLength++;
            } else {
                maxLength = 1; // Reset to 1 if not consecutive
            }
            
            int index = s.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], maxLength); // Update dp array for the current character
        }
        
        // Sum up all values in dp array to get the number of unique substrings
        int result = 0;
        for (int count : dp) {
            result += count;
        }
        
        return result;
    }
}
