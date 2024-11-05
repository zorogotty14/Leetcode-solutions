class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        // Possible moves for the knight
        int[][] directions = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        // Initialize a 3D DP array
        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1.0;

        // Calculate probabilities for each move count up to k
        for (int m = 1; m <= k; m++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Only process cells that had a non-zero probability in the previous step
                    if (dp[m - 1][i][j] > 0) {
                        for (int[] dir : directions) {
                            int ni = i + dir[0];
                            int nj = j + dir[1];

                            // Check if the new position is within bounds
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[m][ni][nj] += dp[m - 1][i][j] / 8.0;
                            }
                        }
                    }
                }
            }
        }

        // Sum probabilities for all cells on the board after k moves
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += dp[k][i][j];
            }
        }
        
        return result;
    }
}
