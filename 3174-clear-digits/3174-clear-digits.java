import java.util.*;

class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Remove the closest non-digit character to the left
                if (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        // Build the final result
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.toString();
    }
}
