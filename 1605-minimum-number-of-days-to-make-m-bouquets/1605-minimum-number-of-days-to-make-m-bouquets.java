class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // If the total required flowers exceed the available flowers, it's impossible to make bouquets
        if (m * k > bloomDay.length) {
            return -1;
        }
        
        // Initialize binary search boundaries
        int left = 1;
        int right = 1_000_000_000;
        int result = -1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // Helper function to determine if we can make the required number of bouquets by a certain day
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int consecutiveFlowers = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                consecutiveFlowers++;
                if (consecutiveFlowers == k) {
                    bouquets++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }
            if (bouquets >= m) {
                return true;
            }
        }

        return false;
    }
}