class Solution {
    // Helper method to check if a number is prime
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Main method to count numbers with a prime number of set bits
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        
        for (int i = left; i <= right; i++) {
            // Count the number of set bits in the binary representation of i
            int setBits = Integer.bitCount(i);
            
            // Check if the number of set bits is a prime number
            if (isPrime(setBits)) {
                count++;
            }
        }
        
        return count;
    }
}
