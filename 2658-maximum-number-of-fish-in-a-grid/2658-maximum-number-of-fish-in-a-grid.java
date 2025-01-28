class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;

        // Iterate through all cells to find the starting point
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c] && grid[r][c] > 0) { // Start DFS from water cells
                    maxFish = Math.max(maxFish, dfs(grid, visited, r, c));
                }
            }
        }

        return maxFish;
    }

    // Helper function for DFS
    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        // Boundary check and visited/water cell check
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true; // Mark as visited
        int fishCount = grid[r][c]; // Count the fish at the current cell

        // Directions for moving up, right, down, and left
        int[] directions = {-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r + directions[i];
            int nc = c + directions[i + 1];
            fishCount += dfs(grid, visited, nr, nc);
        }

        return fishCount;
    }
}
