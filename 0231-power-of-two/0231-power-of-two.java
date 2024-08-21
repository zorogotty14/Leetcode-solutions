class Solution {
    public boolean isPowerOfTwo(int n) {
        // n must be greater than 0 and n & (n - 1) should be 0 for it to be a power of two
        return n > 0 && (n & (n - 1)) == 0;
    }
}