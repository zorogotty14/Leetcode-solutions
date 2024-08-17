class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        // Initialize dp with the first row values
        long[] dp = new long[n];
        for (int c = 0; c < n; c++) {
            dp[c] = points[0][c];
        }

        // Iterate over each row starting from the second one
        for (int r = 1; r < m; r++) {
            long[] left_max = new long[n];
            long[] right_max = new long[n];

            // Calculate left_max: maximum we can get moving from left to right
            left_max[0] = dp[0];
            for (int c = 1; c < n; c++) {
                left_max[c] = Math.max(left_max[c - 1] - 1, dp[c]);
            }

            // Calculate right_max: maximum we can get moving from right to left
            right_max[n - 1] = dp[n - 1];
            for (int c = n - 2; c >= 0; c--) {
                right_max[c] = Math.max(right_max[c + 1] - 1, dp[c]);
            }

            // Calculate the dp for the current row
            for (int c = 0; c < n; c++) {
                dp[c] = points[r][c] + Math.max(left_max[c], right_max[c]);
            }
        }

        // The maximum value in dp array will be the answer
        long maxPoints = 0;
        for (int c = 0; c < n; c++) {
            maxPoints = Math.max(maxPoints, dp[c]);
        }

        return maxPoints;
    }
}
