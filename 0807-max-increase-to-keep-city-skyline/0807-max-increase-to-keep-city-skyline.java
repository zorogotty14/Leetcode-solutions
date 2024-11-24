class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];
        
        // Find the maximum height for each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        
        int totalIncrease = 0;
        
        // Calculate the maximum possible increase for each building
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int newHeight = Math.min(rowMax[i], colMax[j]);
                totalIncrease += newHeight - grid[i][j];
            }
        }
        
        return totalIncrease;
    }
}
