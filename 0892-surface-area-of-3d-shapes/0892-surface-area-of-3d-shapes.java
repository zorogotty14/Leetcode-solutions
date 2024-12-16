class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalSurfaceArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    // Add the top and bottom faces
                    totalSurfaceArea += 2;

                    // Add the lateral faces (initially 4 * grid[i][j])
                    totalSurfaceArea += 4 * grid[i][j];

                    // Subtract the overlaps with the cube above (if any)
                    if (i > 0) {
                        totalSurfaceArea -= 2 * Math.min(grid[i][j], grid[i - 1][j]);
                    }

                    // Subtract the overlaps with the cube to the left (if any)
                    if (j > 0) {
                        totalSurfaceArea -= 2 * Math.min(grid[i][j], grid[i][j - 1]);
                    }
                }
            }
        }

        return totalSurfaceArea;
    }
}
