import java.util.HashMap;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int total = 0;

        // Array of HashMaps to store counts of arithmetic subsequences
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        // Iterate over all indices
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            // Compare with all previous elements
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];

                // If diff is out of integer bounds, skip this pair
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }

                int diffInt = (int) diff;

                // Get counts from dp[j] and dp[i]
                int countAtJ = dp[j].getOrDefault(diffInt, 0);
                int countAtI = dp[i].getOrDefault(diffInt, 0);

                // Update dp[i] for this difference
                dp[i].put(diffInt, countAtI + countAtJ + 1);

                // Add countAtJ to total number of arithmetic subsequences
                total += countAtJ;
            }
        }

        return total;
    }
}
