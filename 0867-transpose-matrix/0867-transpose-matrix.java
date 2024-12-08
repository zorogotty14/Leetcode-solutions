class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length; // Number of rows in the input matrix
        int n = matrix[0].length; // Number of columns in the input matrix

        // Create a new matrix with dimensions n x m
        int[][] transposed = new int[n][m];

        // Iterate through the input matrix and transpose
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed; // Return the transposed matrix
    }
}
