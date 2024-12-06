class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Step 1: Ensure the first column has all 1's by toggling rows
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                toggleRow(grid, i);
            }
        }
        
        // Step 2: Toggle columns to maximize 1's in each column
        for (int j = 1; j < n; j++) {
            int onesCount = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    onesCount++;
                }
            }
            // If 0's are more than 1's, toggle the column
            if (onesCount < m - onesCount) {
                toggleColumn(grid, j);
            }
        }
        
        // Step 3: Calculate the total score
        int score = 0;
        for (int i = 0; i < m; i++) {
            int rowValue = 0;
            for (int j = 0; j < n; j++) {
                rowValue = rowValue * 2 + grid[i][j];
            }
            score += rowValue;
        }
        
        return score;
    }
    
    private void toggleRow(int[][] grid, int row) {
        for (int j = 0; j < grid[row].length; j++) {
            grid[row][j] ^= 1; // Flip 0 to 1 and 1 to 0
        }
    }
    
    private void toggleColumn(int[][] grid, int col) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] ^= 1; // Flip 0 to 1 and 1 to 0
        }
    }
}
