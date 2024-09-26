class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If it's a land cell
                if (grid[i][j] == 1) {
                    perimeter += 4;  // Start by adding 4 sides for this cell
                    
                    // Check if there is a neighboring land cell to the right
                    if (j + 1 < cols && grid[i][j + 1] == 1) {
                        perimeter -= 2; // Shared edge, subtract 2
                    }
                    
                    // Check if there is a neighboring land cell below
                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        perimeter -= 2; // Shared edge, subtract 2
                    }
                }
            }
        }
        
        return perimeter;
    }
}
