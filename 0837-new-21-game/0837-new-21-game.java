class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Edge case: if k == 0, Alice doesn't draw any cards
        // Or if n >= k + maxPts, Alice always reaches n or fewer points
        if (k == 0 || n >= k + maxPts) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0; // Starting point
        double windowSum = 1.0; // Current sum of probabilities in the sliding window
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;
            // Add dp[i] to result if i >= k (stopping condition)
            if (i >= k) result += dp[i];
            // Update the sliding window
            if (i < k) windowSum += dp[i];
            if (i - maxPts >= 0) windowSum -= dp[i - maxPts];
        }

        return result;
    }
}
