class Solution {
    public int minDays(int[][] grid) {
        if (!isConnected(grid)) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        // Check if we can disconnect the grid by removing just one land cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (!isConnected(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1; // revert the change
                }
            }
        }
        
        // If one cell isn't enough, we know two cells will be
        return 2;
    }
    
    private boolean isConnected(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (count > 0) return false; // More than one island found
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        
        return count == 1;
    }
    
    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }
}
