class Solution {
    public int findComplement(int num) {
        // Find the number of bits required to represent num in binary
        int bitLength = Integer.toBinaryString(num).length();
        
        // Create a mask that has all bits set to 1 for the bit length of num
        int mask = (1 << bitLength) - 1;
        
        // XOR num with the mask to flip all bits
        return num ^ mask;
    }
}