class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isMagicSquare(int[][] grid, int r, int c) {
        // A 3x3 magic square must contain the numbers 1 to 9.
        int[] values = new int[9];
        int k = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9) {
                    return false;
                }
                values[k++] = grid[i][j];
            }
        }
        
        // Check for distinct values
        boolean[] seen = new boolean[10]; // Indices 1-9 are used
        for (int val : values) {
            if (seen[val]) return false;
            seen[val] = true;
        }
        
        // Check rows, columns, and diagonals
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        if (grid[r+1][c] + grid[r+1][c+1] + grid[r+1][c+2] != sum) return false;
        if (grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2] != sum) return false;
        if (grid[r][c] + grid[r+1][c] + grid[r+2][c] != sum) return false;
        if (grid[r][c+1] + grid[r+1][c+1] + grid[r+2][c+1] != sum) return false;
        if (grid[r][c+2] + grid[r+1][c+2] + grid[r+2][c+2] != sum) return false;
        if (grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != sum) return false;
        if (grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != sum) return false;
        
        return true;
    }
}
