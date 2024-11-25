class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n + 1][k + 1];
        double[] prefixSum = new double[n + 1];

        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Initialize dp for the case where k = 1 (only one subarray)
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefixSum[i] / i;
        }

        // Fill DP table
        for (int partitions = 2; partitions <= k; partitions++) {
            for (int i = partitions; i <= n; i++) {
                for (int j = partitions - 1; j < i; j++) {
                    // Maximum score by splitting at `j`
                    dp[i][partitions] = Math.max(
                        dp[i][partitions],
                        dp[j][partitions - 1] + (prefixSum[i] - prefixSum[j]) / (i - j)
                    );
                }
            }
        }

        return dp[n][k];
    }
}
