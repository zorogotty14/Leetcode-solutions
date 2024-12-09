class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles);
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                result = mid; // Update the result to the current feasible speed
                right = mid - 1; // Try smaller speeds
            } else {
                left = mid + 1; // Try larger speeds
            }
        }

        return result;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + k - 1) / k; // Equivalent to ceil(pile / k)
            if (totalHours > h) {
                return false; // Early exit if totalHours exceeds h
            }
        }
        return totalHours <= h;
    }
}
