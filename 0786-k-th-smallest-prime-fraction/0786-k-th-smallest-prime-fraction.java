import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double low = 0.0, high = 1.0;
        int[] result = new int[2];

        while (true) {
            double mid = (low + high) / 2.0;
            int count = 0; // Number of fractions <= mid
            int p = 0, q = 1; // Stores the numerator and denominator of the best fraction found so far
            int j = 1; // Two pointer approach: the denominator index

            // Count the fractions <= mid using a two-pointer technique
            for (int i = 0; i < n; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }
                if (j < n) {
                    count += (n - j); // All fractions with denominator >= j are valid
                    if (p * arr[j] < q * arr[i]) {
                        p = arr[i];
                        q = arr[j];
                    }
                }
            }

            // Adjust the binary search bounds
            if (count == k) {
                result[0] = p;
                result[1] = q;
                break;
            } else if (count < k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return result;
    }
}
