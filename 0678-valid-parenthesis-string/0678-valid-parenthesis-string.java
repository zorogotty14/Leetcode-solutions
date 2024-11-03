class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;  // Minimum possible open parentheses
        int maxOpen = 0;  // Maximum possible open parentheses

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;   // Treat '(' as an increase in open parentheses
                maxOpen++;
            } else if (c == ')') {
                minOpen = Math.max(0, minOpen - 1); // Treat ')' as a decrease in open parentheses
                maxOpen--;
            } else {  // c == '*'
                minOpen = Math.max(0, minOpen - 1); // '*' can act as ')', so minOpen may decrease
                maxOpen++;                          // '*' can act as '(', so maxOpen may increase
            }

            // If maxOpen is negative, there are too many ')'
            if (maxOpen < 0) {
                return false;
            }
        }

        // If minOpen is 0, we have a balanced set of parentheses
        return minOpen == 0;
    }
}
