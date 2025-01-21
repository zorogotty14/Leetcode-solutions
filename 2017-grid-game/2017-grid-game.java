class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Calculate the prefix sum for both rows
        long[] topPrefixSum = new long[n + 1]; // Prefix sum for grid[0]
        long[] bottomPrefixSum = new long[n + 1]; // Prefix sum for grid[1]

        for (int i = 0; i < n; i++) {
            topPrefixSum[i + 1] = topPrefixSum[i] + grid[0][i];
            bottomPrefixSum[i + 1] = bottomPrefixSum[i] + grid[1][i];
        }

        long minPointsCollectedBySecondRobot = Long.MAX_VALUE;

        // Iterate through all possible split points for the first robot
        for (int i = 0; i < n; i++) {
            // Points collected by the second robot in the two regions
            long pointsTop = topPrefixSum[n] - topPrefixSum[i + 1]; // Remaining points on the top row
            long pointsBottom = bottomPrefixSum[i]; // Remaining points on the bottom row

            // The second robot maximizes its points, so it will choose the larger region
            long maxPointsSecondRobot = Math.max(pointsTop, pointsBottom);

            // The first robot tries to minimize this value
            minPointsCollectedBySecondRobot = Math.min(minPointsCollectedBySecondRobot, maxPointsSecondRobot);
        }

        return minPointsCollectedBySecondRobot;
    }
}
