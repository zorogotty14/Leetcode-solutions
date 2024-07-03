class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        // Numbers with last digit 0 and not equal to 0 are not palindromes
        if (x != 0 && x % 10 == 0) {
            return false;
        }

        // Reverse the second half of the number
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // When the length is odd, we can ignore the middle digit
        return x == reversed || x == reversed / 10;
    }
}