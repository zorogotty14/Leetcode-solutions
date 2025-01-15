class Solution {
    public int minimizeXor(int num1, int num2) {
        // Count the number of set bits in num2
        int setBitsNum2 = Integer.bitCount(num2);

        // Initialize x and count of bits set in x
        int x = 0;
        int setBitsInX = 0;

        // Step 1: Try to align bits of num1 with num2's set bit count
        for (int i = 31; i >= 0; i--) {
            if ((num1 & (1 << i)) != 0 && setBitsInX < setBitsNum2) {
                x |= (1 << i); // Set the bit in x
                setBitsInX++;
            }
        }

        // Step 2: If more set bits are needed, add them from the least significant bit
        for (int i = 0; i < 32 && setBitsInX < setBitsNum2; i++) {
            if ((x & (1 << i)) == 0) { // If the bit is not already set in x
                x |= (1 << i);
                setBitsInX++;
            }
        }

        return x;
    }
}
