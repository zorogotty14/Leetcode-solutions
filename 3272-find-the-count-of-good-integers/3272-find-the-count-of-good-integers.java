class Solution {
    public long countGoodIntegers(int n, int k) {
        long count = 0;
        HashSet<String> uniqueDigitSets = new HashSet<>();

        // Check if n is even or odd to determine palindrome construction logic
        if (n % 2 == 0) {
            int halfLength = n / 2;

            for (int i = (int) Math.pow(10, halfLength - 1); i < Math.pow(10, halfLength); i++) {
                String left = String.valueOf(i);
                String right = new StringBuilder(left).reverse().toString();
                String palindrome = left + right;

                long number = Long.parseLong(palindrome);
                if (number % k == 0) {
                    char[] digits = palindrome.toCharArray();
                    Arrays.sort(digits);
                    uniqueDigitSets.add(new String(digits));
                }
            }
        } else {
            int halfLength = (n - 1) / 2;

            for (int i = (int) Math.pow(10, halfLength); i < Math.pow(10, halfLength + 1); i++) {
                String left = String.valueOf(i);
                String right = new StringBuilder(left.substring(0, left.length() - 1)).reverse().toString();
                String palindrome = left + right;

                long number = Long.parseLong(palindrome);
                if (number % k == 0) {
                    char[] digits = palindrome.toCharArray();
                    Arrays.sort(digits);
                    uniqueDigitSets.add(new String(digits));
                }
            }
        }

        // Count permutations of digit sets that form valid numbers
        for (String digitSet : uniqueDigitSets) {
            long numerator = 1;
            long denominator = 1;
            int repeatCount = 1;
            int zeroCount = (digitSet.charAt(0) == '0') ? 1 : 0;

            for (int i = 1; i < digitSet.length(); i++) {
                numerator *= (i + 1);

                if (digitSet.charAt(i) == digitSet.charAt(i - 1)) {
                    repeatCount++;
                } else {
                    repeatCount = 1;
                }

                denominator *= repeatCount;

                if (digitSet.charAt(i) == '0') {
                    zeroCount++;
                }
            }

            // Adjust count if there are leading zeros
            if (zeroCount > 0) {
                count += (numerator / denominator) - ((numerator / digitSet.length()) / (denominator / zeroCount));
            } else {
                count += (numerator / denominator);
            }
        }

        return count;
    }
}
