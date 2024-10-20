class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;         // Number of rows in the original matrix
        int n = mat[0].length;      // Number of columns in the original matrix
        
        // Check if reshape is possible
        if (m * n != r * c) {
            return mat;  // Return the original matrix if reshape is not possible
        }
        
        int[][] reshapedMatrix = new int[r][c];  // New matrix of size r x c
        int row = 0, col = 0;  // Pointers for the reshaped matrix

        // Traverse the original matrix in row-major order
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reshapedMatrix[row][col] = mat[i][j];  // Fill the reshaped matrix
                col++;  // Move to the next column
                
                // If we reach the end of a row, move to the next row
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        
        return reshapedMatrix;
    }
}
