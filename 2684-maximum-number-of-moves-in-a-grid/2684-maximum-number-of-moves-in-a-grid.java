class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Create a DP array to store the maximum moves for each cell
        int[][] dp = new int[m][n];

        // Initialize the result variable to store the maximum moves across all paths
        int result = 0;

        // Iterate over each column from the second-last to the first column
        for (int col = n - 2; col >= 0; col--) {
            for (int row = 0; row < m; row++) {
                // Check the three possible moves: top-right, right, bottom-right
                if (row > 0 && grid[row][col] < grid[row - 1][col + 1]) {
                    dp[row][col] = Math.max(dp[row][col], dp[row - 1][col + 1] + 1);
                }
                if (grid[row][col] < grid[row][col + 1]) {
                    dp[row][col] = Math.max(dp[row][col], dp[row][col + 1] + 1);
                }
                if (row < m - 1 && grid[row][col] < grid[row + 1][col + 1]) {
                    dp[row][col] = Math.max(dp[row][col], dp[row + 1][col + 1] + 1);
                }
            }
        }

        // Calculate the maximum moves starting from any cell in the first column
        for (int row = 0; row < m; row++) {
            result = Math.max(result, dp[row][0]);
        }

        return result;
    }
}
