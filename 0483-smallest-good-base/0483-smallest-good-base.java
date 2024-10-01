import java.math.*;

class Solution {
    public String smallestGoodBase(String nStr) {
        long n = Long.parseLong(nStr);

        // Loop over possible values of m (number of 1's - 1)
        for (int m = (int) (Math.log(n + 1) / Math.log(2)); m >= 1; m--) {
            long left = 2, right = (long) Math.pow(n, 1.0 / m);

            while (left <= right) {
                long mid = left + (right - left) / 2;
                BigInteger base = BigInteger.valueOf(mid);
                BigInteger sum = BigInteger.ZERO;
                BigInteger currentPow = BigInteger.ONE;

                // Calculate the sum of the geometric series for this base
                for (int i = 0; i <= m; i++) {
                    sum = sum.add(currentPow);
                    currentPow = currentPow.multiply(base);
                }

                BigInteger target = BigInteger.valueOf(n);

                if (sum.equals(target)) {
                    return String.valueOf(mid); // Found the base
                } else if (sum.compareTo(target) < 0) {
                    left = mid + 1; // Need a larger base
                } else {
                    right = mid - 1; // Need a smaller base
                }
            }
        }

        // If no smaller base is found, return n-1 as the smallest good base
        return String.valueOf(n - 1);
    }
}
