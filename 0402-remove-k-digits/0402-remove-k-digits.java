class Solution {
    public String removeKdigits(String num, int k) {
        // Step 1: Initialize a stack to store the resulting digits
        StringBuilder stack = new StringBuilder();
        
        // Step 2: Traverse each digit in the num string
        for (char digit : num.toCharArray()) {
            // While we can remove more digits (k > 0), and the top of the stack is greater than the current digit
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1); // Remove the top element
                k--; // Decrease k as we removed one element
            }
            // Add the current digit to the stack
            stack.append(digit);
        }
        
        // Step 3: If we still have k digits left to remove, remove them from the end of the stack
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        
        // Step 4: Remove any leading zeros
        while (stack.length() > 0 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }
        
        // Step 5: If the stack is empty, return "0", else return the stack as a string
        return stack.length() == 0 ? "0" : stack.toString();
    }
}
