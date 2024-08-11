class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = n * 3;
        int[][] expandedGrid = new int[size][size];
        
        // Expand the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);  // Use charAt to get the character at position j
                if (c == '/') {
                    expandedGrid[i * 3][j * 3 + 2] = 1;
                    expandedGrid[i * 3 + 1][j * 3 + 1] = 1;
                    expandedGrid[i * 3 + 2][j * 3] = 1;
                } else if (c == '\\') {
                    expandedGrid[i * 3][j * 3] = 1;
                    expandedGrid[i * 3 + 1][j * 3 + 1] = 1;
                    expandedGrid[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        
        // Use DFS to count connected components
        int regions = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (expandedGrid[i][j] == 0) {
                    regions++;
                    dfs(expandedGrid, i, j, size);
                }
            }
        }
        
        return regions;
    }
    
    private void dfs(int[][] grid, int i, int j, int size) {
        if (i < 0 || j < 0 || i >= size || j >= size || grid[i][j] != 0) {
            return;
        }
        
        grid[i][j] = -1; // Mark the cell as visited
        
        dfs(grid, i + 1, j, size); // Down
        dfs(grid, i - 1, j, size); // Up
        dfs(grid, i, j + 1, size); // Right
        dfs(grid, i, j - 1, size); // Left
    }
}
