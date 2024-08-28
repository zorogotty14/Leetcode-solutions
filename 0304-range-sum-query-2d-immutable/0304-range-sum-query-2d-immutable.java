public class NumMatrix {

    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;

        prefixSum = new int[m + 1][n + 1];

        // Compute prefix sum for the matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] 
                                + prefixSum[i - 1][j] 
                                + prefixSum[i][j - 1] 
                                - prefixSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Adjust for the 1-based prefixSum indexing
        row1++;
        col1++;
        row2++;
        col2++;
        return prefixSum[row2][col2] 
             - prefixSum[row1 - 1][col2] 
             - prefixSum[row2][col1 - 1] 
             + prefixSum[row1 - 1][col1 - 1];
    }
}
