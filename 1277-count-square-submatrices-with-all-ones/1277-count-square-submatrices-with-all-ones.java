class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int totalSquares = 0;

        // Iterate through the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // If we're on the first row or first column, the largest square is just the cell itself
                        dp[i][j] = 1;
                    } else {
                        // Use the transition formula
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    // Add the number of squares ending at (i, j) to the total
                    totalSquares += dp[i][j];
                }
            }
        }

        return totalSquares;
    }
}
