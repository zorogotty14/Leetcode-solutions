class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        // 3D DP memoization table
        int[][][] memo = new int[n][n][n];
        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dp(grid, 0, 0, 0, memo));
    }

    private int dp(int[][] grid, int r1, int c1, int r2, int[][][] memo) {
        int n = grid.length;
        int c2 = r1 + c1 - r2; // The relation between positions of the two paths

        // Base cases
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        // If both paths reach the bottom-right corner
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        // If already computed
        if (memo[r1][c1][r2] != Integer.MIN_VALUE) {
            return memo[r1][c1][r2];
        }

        // Collect cherries
        int cherries = grid[r1][c1];
        if (r1 != r2 || c1 != c2) { // Avoid double counting the same cell
            cherries += grid[r2][c2];
        }

        // Move to the next states
        int next = Math.max(
            Math.max(dp(grid, r1 + 1, c1, r2 + 1, memo), dp(grid, r1 + 1, c1, r2, memo)),
            Math.max(dp(grid, r1, c1 + 1, r2 + 1, memo), dp(grid, r1, c1 + 1, r2, memo))
        );

        cherries += next;
        memo[r1][c1][r2] = cherries;
        return cherries;
    }
}
