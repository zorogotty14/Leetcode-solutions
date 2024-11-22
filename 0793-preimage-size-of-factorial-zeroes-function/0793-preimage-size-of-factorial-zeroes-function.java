class Solution {
    public int preimageSizeFZF(int k) {
        return findRange(k + 1) - findRange(k);
    }

    // Function to find the smallest x such that f(x) >= k
    private int findRange(int k) {
        long low = 0, high = 5L * (k + 1); // Upper bound based on k
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (trailingZeroes(mid) >= k) {
                high = mid; // Reduce high to find the lower bound
            } else {
                low = mid + 1; // Increase low to move closer to k
            }
        }
        return (int) low;
    }

    // Function to calculate f(x) = number of trailing zeroes in x!
    private long trailingZeroes(long x) {
        long count = 0;
        while (x > 0) {
            count += x / 5;
            x /= 5;
        }
        return count;
    }
}
