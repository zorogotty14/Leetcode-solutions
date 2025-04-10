class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        // Convert the suffix string to a number
        long suffixValue = 0;
        for (char c : s.toCharArray()) {
            suffixValue = suffixValue * 10 + (c - '0');
        }

        // If suffix is greater than the finish range, no valid number exists
        if (suffixValue > finish) {
            return 0;
        }

        long base = (long) Math.pow(10, s.length());

        // Calculate prefix bounds for start and finish ranges
        long prefixStart = start / base;
        long prefixFinish = finish / base;

        // Adjust prefix range based on suffix alignment
        if (finish % base >= suffixValue) prefixFinish++;
        if (start % base > suffixValue) prefixStart++;

        // Count valid prefixes for the range [prefixStart, prefixFinish)
        return countValidPrefixes(prefixFinish, limit) - countValidPrefixes(prefixStart, limit);
    }

    // Helper method to count numbers less than `num` where each digit <= limit
    private long countValidPrefixes(long num, long limit) {
        if (num == 0) return 0;
        if (limit == 9) return num;  // All digits are valid

        int digitCount = (int) Math.log10(num);
        long divisor = (long) Math.pow(10, digitCount);
        long result = 0;

        for (int i = digitCount; i >= 0; i--) {
            int currentDigit = (int) (num / divisor);

            if (currentDigit > limit) {
                // All combinations from this point on are valid
                return result + (long) Math.pow(limit + 1, i + 1);
            }

            result += currentDigit * (long) Math.pow(limit + 1, i);
            num %= divisor;
            divisor /= 10;
        }

        return result;
    }
}
