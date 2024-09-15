class Solution {
    public String addStrings(String num1, String num2) {
        // StringBuilder to store the result
        StringBuilder result = new StringBuilder();
        
        // Initialize two pointers for num1 and num2, and a carry variable
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        // Iterate over the digits from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            // Get the current digit of num1, or 0 if i < 0
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            // Get the current digit of num2, or 0 if j < 0
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            
            // Compute the sum of the two digits and the carry
            int sum = digit1 + digit2 + carry;
            
            // Append the last digit of the sum to the result
            result.append(sum % 10);
            
            // Update the carry for the next iteration
            carry = sum / 10;
            
            // Move to the next digits
            i--;
            j--;
        }
        
        // The result is currently in reverse order, so reverse it
        return result.reverse().toString();
    }
}
