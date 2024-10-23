class Solution {
    public int findIntegers(int n) {
        // Step 1: Precompute Fibonacci numbers up to 30 (since n <= 10^9)
        int[] fib = new int[31]; 
        fib[0] = 1;  // Only one valid 0-bit number: 0
        fib[1] = 2;  // Two valid 1-bit numbers: 0 and 1

        // Fill the Fibonacci array
        for (int i = 2; i < 31; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        // Step 2: Traverse the binary representation of n from MSB to LSB
        int prevBit = 0, result = 0;

        // Iterate over the bits of n (from the 30th bit to the 0th bit)
        for (int i = 29; i >= 0; i--) {
            // Check if the i-th bit of n is set (1)
            if ((n & (1 << i)) != 0) {
                // Add the count of valid numbers with i bits
                result += fib[i];

                // If there are consecutive ones, break early
                if (prevBit == 1) {
                    result--;  // Exclude the current number n
                    break;
                }
                prevBit = 1;  // Mark this bit as 1
            } else {
                prevBit = 0;  // Mark this bit as 0
            }
        }

        // Step 3: Include n itself if it doesn't contain consecutive ones
        return result + 1;
    }
}
