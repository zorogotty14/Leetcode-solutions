class Solution {
    public boolean isPowerOfFour(int n) {
        // Check if n is a positive power of 2 and the only set bit is at an even position.
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
