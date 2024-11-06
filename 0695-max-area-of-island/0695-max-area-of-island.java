class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate over every cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Start a DFS if we encounter a 1 (land)
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    // Helper method to perform DFS and calculate the area of the island
    private int dfs(int[][] grid, int r, int c) {
        // Boundary check and check if cell is water or already visited
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        // Mark the cell as visited
        grid[r][c] = 0;

        // Calculate the area of the current island
        int area = 1; // Count the current cell
        // Explore all 4 directions
        area += dfs(grid, r + 1, c);
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r, c - 1);

        return area;
    }
}
