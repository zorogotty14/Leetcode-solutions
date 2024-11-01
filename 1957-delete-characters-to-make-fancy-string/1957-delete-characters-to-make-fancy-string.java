class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // To count consecutive characters
        
        // Append the first character to the result as the starting point
        result.append(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            // Check if the current character is the same as the previous one
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1; // Reset the count if characters are different
            }
            
            // Only add the character if count is less than 3
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}
