class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int k = 1; // Start with 1 number in the sequence

        while (true) {
            // Compute k(k-1)/2
            int sumK = k * (k - 1) / 2;

            // If sumK exceeds n, we can't find any more valid k
            if (sumK > n) {
                break;
            }

            // Ensure n - sumK > 0 and (n - sumK) is divisible by k
            if ((n - sumK) > 0 && (n - sumK) % k == 0) {
                count++;
            }

            k++;
        }

        return count;
    }
}
