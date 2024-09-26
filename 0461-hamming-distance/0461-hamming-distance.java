class Solution {
    public int hammingDistance(int x, int y) {
        // XOR the two numbers
        int xor = x ^ y;
        
        // Count the number of 1s in the binary representation of the result
        int count = 0;
        while (xor != 0) {
            // Increment count if the last bit is 1
            count += xor & 1;
            // Right shift to check the next bit
            xor >>= 1;
        }
        
        return count;
    }
}
