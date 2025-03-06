class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] frequency = new int[n * n + 1];
        int repeated = -1, missing = -1;
        
        // Count the frequency of each number in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                frequency[grid[i][j]]++;
            }
        }
        
        // Identify the repeated and missing numbers
        for (int i = 1; i <= n * n; i++) {
            if (frequency[i] == 2) {
                repeated = i;
            } else if (frequency[i] == 0) {
                missing = i;
            }
            if (repeated != -1 && missing != -1) break;
        }
        
        return new int[]{repeated, missing};
    }
}