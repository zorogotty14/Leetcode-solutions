class Solution {
    public boolean isNumber(String s) {
        // Trim the input to remove leading and trailing spaces
        s = s.trim();
        
        // Define flags for different components of a valid number
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;
        
        // Iterate through each character of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '.') {
                // If a dot is already seen or 'e' is seen before, return false
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // If 'e' is already seen or no digit is seen before 'e', return false
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                // Reset seenDigit flag to ensure there are digits after 'e'
                seenDigit = false;
            } else if (c == '+' || c == '-') {
                // Sign must be at the beginning or just after 'e'
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                // Any other character makes the number invalid
                return false;
            }
        }
        
        // Return true if there is at least one digit in the valid number
        return seenDigit;
    }
}