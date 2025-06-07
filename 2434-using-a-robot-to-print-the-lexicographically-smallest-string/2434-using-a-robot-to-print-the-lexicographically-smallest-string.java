import java.util.*;

class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minSuffix = new char[n];
        minSuffix[n - 1] = s.charAt(n - 1);

        // Step 1: Build suffix min array
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(s.charAt(i), minSuffix[i + 1]);
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int i = 0;

        // Step 2: Process characters
        while (i < n) {
            stack.push(s.charAt(i));

            // Step 3: Check if we can pop from stack to result
            while (!stack.isEmpty() && (i == n - 1 || stack.peek() <= minSuffix[i + 1])) {
                result.append(stack.pop());
            }
            i++;
        }

        // Step 4: Empty remaining characters from stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
