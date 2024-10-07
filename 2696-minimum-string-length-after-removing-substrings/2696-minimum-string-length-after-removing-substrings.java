class Solution {
    public int minLength(String s) {
        // Initialize a stack to process the string
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // Check if the stack has an element and the current pair matches "AB" or "CD"
            if (!stack.isEmpty() && 
                ((stack.peek() == 'A' && c == 'B') || (stack.peek() == 'C' && c == 'D'))) {
                // Remove the matching pair by popping the stack
                stack.pop();
            } else {
                // Otherwise, push the current character onto the stack
                stack.push(c);
            }
        }
        
        // The remaining length of the stack is the minimized length of the string
        return stack.size();
    }
}
