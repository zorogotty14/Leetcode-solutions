class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int marker = digits.length;
        
        // Traverse from right to left
        for (int i = digits.length - 1; i > 0; i--) {
            // If the current digit is smaller than the previous digit
            if (digits[i] < digits[i - 1]) {
                // Decrease the previous digit
                digits[i - 1]--;
                // Mark the position where digits need to be set to 9
                marker = i;
            }
        }
        
        // Set all digits to the right of marker to 9
        for (int i = marker; i < digits.length; i++) {
            digits[i] = '9';
        }

        return Integer.parseInt(new String(digits));
    }
}
