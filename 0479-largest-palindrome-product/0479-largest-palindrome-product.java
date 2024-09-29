class Solution {
    public int largestPalindrome(int n) {
        // Special case for n = 1
        if (n == 1) {
            return 9;
        }

        // Upper and lower limits for n-digit numbers
        int upperLimit = (int) Math.pow(10, n) - 1;
        int lowerLimit = (int) Math.pow(10, n - 1);
        
        // Start from the largest possible palindrome (formed from two n-digit numbers)
        long maxPalindrome = 0;

        // Try to find the largest palindrome by multiplying two n-digit numbers
        for (int i = upperLimit; i >= lowerLimit; i--) {
            for (int j = i; j >= lowerLimit; j--) {
                long product = (long) i * j;
                if (isPalindrome(product)) {
                    maxPalindrome = Math.max(maxPalindrome, product);
                }
            }
        }

        // Return the largest palindrome modulo 1337
        return (int) (maxPalindrome % 1337);
    }

    // Helper function to check if a number is a palindrome
    private boolean isPalindrome(long num) {
        long original = num, reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return original == reversed;
    }
}
