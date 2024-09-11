class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR the start and goal to find differing bits
        int xor = start ^ goal;
        
        // Count the number of 1s in the binary representation of xor
        int count = 0;
        while (xor != 0) {
            // Increment count if the last bit is 1
            count += xor & 1;
            // Right shift xor to check the next bit
            xor >>= 1;
        }
        
        return count;
    }
}
