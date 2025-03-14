class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = (int)1e7; // Max candies[i] constraint is 10^7
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, k, mid)) {
                result = mid; // Store the max valid candies per child
                left = mid + 1; // Try for more candies per child
            } else {
                right = mid - 1; // Try for fewer candies per child
            }
        }
        return result;
    }

    private boolean canDistribute(int[] candies, long k, int mid) {
        long count = 0; // Count of children we can serve
        for (int candy : candies) {
            count += candy / mid; // Number of children served by this pile
            if (count >= k) return true; // We can distribute enough
        }
        return count >= k;
    }
}
