class Solution {
    public boolean hasAlternatingBits(int n) {
        int xor = n ^ (n >> 1); // XOR n with n shifted one bit to the right
        return (xor & (xor + 1)) == 0; // Check if all bits are set
    }
}
