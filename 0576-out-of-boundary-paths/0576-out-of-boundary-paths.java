class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] memo;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Initialize memoization table with -1 (indicating unvisited states)
        memo = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        // Start the DFS from the initial position
        return dfs(m, n, maxMove, startRow, startColumn);
    }

    private int dfs(int m, int n, int moves, int i, int j) {
        // If the ball is out of bounds, return 1 as this is a valid path
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }

        // If no moves are left, return 0 as no valid path exists
        if (moves == 0) {
            return 0;
        }

        // If this state has been computed before, return the cached result
        if (memo[i][j][moves] != -1) {
            return memo[i][j][moves];
        }

        // Calculate the number of paths by moving in four directions
        long paths = 0;
        paths += dfs(m, n, moves - 1, i - 1, j);  // Up
        paths += dfs(m, n, moves - 1, i + 1, j);  // Down
        paths += dfs(m, n, moves - 1, i, j - 1);  // Left
        paths += dfs(m, n, moves - 1, i, j + 1);  // Right

        // Store the result in memoization table and return it modulo MOD
        memo[i][j][moves] = (int) (paths % MOD);
        return memo[i][j][moves];
    }
}
