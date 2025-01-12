class Solution {
    public boolean canBeValid(String s, String locked) {
        // If the string length is odd, it can't be valid
        if (s.length() % 2 != 0) {
            return false;
        }

        // Variables to track balance
        int open = 0, balance = 0;

        // First pass: Check if we can balance from left to right
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(') {
                open++;
            } else {
                open--;
            }
            if (open < 0) {
                return false; // Too many closing brackets
            }
        }

        // Second pass: Check if we can balance from right to left
        int close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')') {
                close++;
            } else {
                close--;
            }
            if (close < 0) {
                return false; // Too many opening brackets
            }
        }

        // If both passes succeed, the string can be valid
        return true;
    }
}
