class Solution {
    public int maximumSwap(int num) {
        // Convert the number to a character array for easy manipulation
        char[] digits = Integer.toString(num).toCharArray();
        
        // Store the last occurrence of each digit (0-9)
        int[] lastIndex = new int[10];
        for (int i = 0; i < digits.length; i++) {
            lastIndex[digits[i] - '0'] = i;
        }

        // Traverse the digits and look for a larger digit to swap
        for (int i = 0; i < digits.length; i++) {
            // Check for a larger digit from 9 to the current digit+1
            for (int d = 9; d > digits[i] - '0'; d--) {
                // If a larger digit exists and it occurs after the current index, swap them
                if (lastIndex[d] > i) {
                    // Swap the two digits
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;
                    // Convert the array back to an integer and return
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        // If no swap is made, return the original number
        return num;
    }
}
