class Solution {
    public boolean isPowerOfThree(int n) {
        // The largest power of 3 that fits in a 32-bit signed integer
        int maxPowerOfThree = 1162261467; // 3^19
        
        // n should be positive and a divisor of maxPowerOfThree
        return n > 0 && (maxPowerOfThree % n == 0);
    }
}
