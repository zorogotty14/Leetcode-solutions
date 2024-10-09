class Solution {
    public int minAddToMakeValid(String s) {
        int open_count = 0;  // To track unmatched '('
        int close_count = 0; // To track unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open_count++;  // We found an unmatched '('
            } else {  // c == ')'
                if (open_count > 0) {
                    open_count--;  // Match this ')' with a previous unmatched '('
                } else {
                    close_count++;  // Unmatched ')'
                }
            }
        }
        
        // Total number of insertions required is the sum of unmatched '(' and ')'
        return open_count + close_count;
    }
}
