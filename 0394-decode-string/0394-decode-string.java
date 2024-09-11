import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();  // To store repeat counts
        Stack<StringBuilder> strStack = new Stack<>();  // To store intermediate results
        StringBuilder currentStr = new StringBuilder();  // Current working string
        int k = 0;  // Current repeat count

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // If it's a digit, build the number (repeat count)
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current repeat count and current string into their respective stacks
                numStack.push(k);
                strStack.push(currentStr);
                // Reset for the next encoded substring
                currentStr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // Pop from both stacks and repeat the current string
                int repeatTimes = numStack.pop();
                StringBuilder temp = currentStr;
                currentStr = strStack.pop();
                // Append the repeated string to the previous part of the string
                while (repeatTimes-- > 0) {
                    currentStr.append(temp);
                }
            } else {
                // Append normal characters to the current string
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }
}
