import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26]; // Frequency of each character
        boolean[] inStack = new boolean[26]; // Whether a character is in the stack
        
        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            freq[index]--;
            
            // If character is already in stack, skip it
            if (inStack[index]) {
                continue;
            }
            
            // Greedily remove characters from stack if they are larger and can be found later
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            inStack[index] = true;
        }
        
        // Build the final result from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}
