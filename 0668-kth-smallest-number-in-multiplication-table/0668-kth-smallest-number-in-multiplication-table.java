class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Count how many numbers are <= mid
            if (countLessThanOrEqual(mid, m, n) >= k) {
                high = mid; // Narrow down the search space
            } else {
                low = mid + 1; // Increase the lower bound
            }
        }

        return low;
    }

    // Helper function to count how many elements are <= mid in the table
    private int countLessThanOrEqual(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count;
    }
}
