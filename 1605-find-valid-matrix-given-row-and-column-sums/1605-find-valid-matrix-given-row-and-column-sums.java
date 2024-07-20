class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Set the value to the minimum of the current row sum and column sum
                int value = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = value;
                // Subtract the value from both row sum and column sum
                rowSum[i] -= value;
                colSum[j] -= value;
            }
        }
        return matrix;
    }
}