class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String target = String.valueOf(n); // Convert n to a string for comparison
        int targetLength = target.length();
        int digitsLength = digits.length;

        // Step 1: Count numbers with lengths less than the target length
        int count = 0;
        for (int i = 1; i < targetLength; i++) {
            count += Math.pow(digitsLength, i); // Numbers with exactly 'i' digits
        }

        // Step 2: Count numbers with the same length as the target
        for (int i = 0; i < targetLength; i++) {
            boolean hasSamePrefix = false;
            for (String d : digits) {
                char digit = d.charAt(0);
                if (digit < target.charAt(i)) {
                    count += Math.pow(digitsLength, targetLength - i - 1);
                } else if (digit == target.charAt(i)) {
                    hasSamePrefix = true;
                } else {
                    break;
                }
            }
            if (!hasSamePrefix) {
                return count;
            }
        }

        // Step 3: Add the target number itself if all digits matched
        return count + 1;
    }
}
