class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0; // Projection on the XY plane (top view)
        int yzArea = 0; // Projection on the YZ plane (side view)
        int zxArea = 0; // Projection on the ZX plane (front view)

        for (int i = 0; i < n; i++) {
            int maxRow = 0; // Maximum in the current row (for ZX projection)
            int maxCol = 0; // Maximum in the current column (for YZ projection)
            for (int j = 0; j < n; j++) {
                // Count non-zero cells for XY projection
                if (grid[i][j] > 0) {
                    xyArea++;
                }
                // Find maximum in the current row
                maxRow = Math.max(maxRow, grid[i][j]);
                // Find maximum in the current column
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            // Add row maximum to ZX projection
            zxArea += maxRow;
            // Add column maximum to YZ projection
            yzArea += maxCol;
        }

        // Total area is the sum of all three projections
        return xyArea + yzArea + zxArea;
    }
}
