class Solution {
    public int countGoodNumbers(long n) {
        final int MOD = 1_000_000_007;
        
        // Calculate how many even and odd positions we have
        long evenPositions = (n + 1) / 2; // Ceiling of n/2 (positions 0, 2, 4...)
        long oddPositions = n / 2;        // Floor of n/2 (positions 1, 3, 5...)
        
        // Calculate 5^evenPositions and 4^oddPositions
        long result = 1;
        
        // Calculate 5^evenPositions
        result = modPow(5, evenPositions, MOD);
        
        // Multiply by 4^oddPositions
        result = (result * modPow(4, oddPositions, MOD)) % MOD;
        
        return (int)result;
    }
    
    // Helper method to calculate (base^exponent) % modulus efficiently
    private long modPow(long base, long exponent, int modulus) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base % modulus;
        
        long half = modPow(base, exponent / 2, modulus);
        long result = (half * half) % modulus;
        
        // If exponent is odd, multiply by one more base
        if (exponent % 2 == 1) {
            result = (result * base) % modulus;
        }
        
        return result;
    }
}