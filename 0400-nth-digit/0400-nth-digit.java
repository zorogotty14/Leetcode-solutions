class Solution {
    public int findNthDigit(int n) {
        // Step 1: Identify the digit group
        int digitLength = 1;  // 1-digit, 2-digits, 3-digits, etc.
        long count = 9;       // Number of digits in the current group
        long start = 1;       // Start of the current digit group (1 for 1-digit, 10 for 2-digits, 100 for 3-digits)

        // Find the digit group (1-digit, 2-digits, etc.)
        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the actual number that contains the nth digit
        long num = start + (n - 1) / digitLength;  // The number in this group
        int index = (n - 1) % digitLength;         // The digit index within the number

        // Step 3: Find the nth digit in that number
        String numStr = Long.toString(num);        // Convert the number to a string
        return numStr.charAt(index) - '0';         // Return the desired digit as an integer
    }
}
