class Solution {
    public int rotatedDigits(int n) {
        // Helper arrays for digit classification
        int[] valid = {0, 1, 8}; // Neutral digits
        int[] good = {2, 5, 6, 9}; // Good digits
        int[] invalid = {3, 4, 7}; // Invalid digits

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isGoodNumber(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isGoodNumber(int num) {
        boolean containsGoodDigit = false;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false; // Invalid digit
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                containsGoodDigit = true; // Contains at least one good digit
            }
            num /= 10;
        }
        return containsGoodDigit;
    }
}
