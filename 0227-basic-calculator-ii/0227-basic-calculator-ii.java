import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        s = s.replaceAll(" ", "");  // Removing any white spaces
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            
            if (!Character.isDigit(currentChar) || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                
                operation = currentChar;
                currentNumber = 0;
            }
        }
        
        int result = 0;
        for (int num : stack) {
            result += num;
        }
        
        return result;
    }
}
