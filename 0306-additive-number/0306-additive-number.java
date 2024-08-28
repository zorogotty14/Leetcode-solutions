public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        // Try all possible pairs for the first two numbers
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                // Extract the first two numbers
                String num1 = num.substring(0, i);
                String num2 = num.substring(i, j);

                // Skip if any number has leading zeros
                if ((num1.length() > 1 && num1.startsWith("0")) || 
                    (num2.length() > 1 && num2.startsWith("0"))) {
                    continue;
                }

                // Check if the rest of the string matches the additive sequence
                if (isValid(num1, num2, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String num1, String num2, String remaining) {
        if (remaining.isEmpty()) {
            return true;
        }

        // Calculate the sum of num1 and num2
        String sum = addStrings(num1, num2);

        // Check if the remaining string starts with this sum
        if (!remaining.startsWith(sum)) {
            return false;
        }

        // Recur with num2 and sum as the next two numbers
        return isValid(num2, sum, remaining.substring(sum.length()));
    }

    private String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}
