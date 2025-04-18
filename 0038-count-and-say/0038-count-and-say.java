class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1) {
            return "1";
        }
        
        // Start with the base case
        String result = "1";
        
        // Iterate from 2 to n
        for (int i = 2; i <= n; i++) {
            result = getNextSequence(result);
        }
        
        return result;
    }
    
    private String getNextSequence(String s) {
        StringBuilder nextSequence = new StringBuilder();
        
        // Initialize count of consecutive digits
        int count = 1;
        
        // Process the string character by character
        for (int i = 0; i < s.length(); i++) {
            // If current character is the same as next
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                // Append the count and character to result
                nextSequence.append(count).append(s.charAt(i));
                count = 1; // Reset count for the next character
            }
        }
        
        return nextSequence.toString();
    }
}