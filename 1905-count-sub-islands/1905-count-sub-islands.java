class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;

        // Traverse through each cell in grid2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start DFS if we find a land cell in grid2
                if (grid2[i][j] == 1) {
                    // Check if this island is a sub-island
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;

        // If out of bounds or this cell is water in grid2, return true (base case)
        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0) {
            return true;
        }

        // If this cell is land in grid2 but water in grid1, it can't be a sub-island
        if (grid1[i][j] == 0) {
            return false;
        }

        // Mark the cell as visited by setting it to 0 in grid2
        grid2[i][j] = 0;

        // DFS in all 4 directions and check if all parts of this island in grid2 are part of grid1
        boolean isSubIsland = true;
        isSubIsland &= dfs(grid1, grid2, i + 1, j);
        isSubIsland &= dfs(grid1, grid2, i - 1, j);
        isSubIsland &= dfs(grid1, grid2, i, j + 1);
        isSubIsland &= dfs(grid1, grid2, i, j - 1);

        return isSubIsland;
    }
}
