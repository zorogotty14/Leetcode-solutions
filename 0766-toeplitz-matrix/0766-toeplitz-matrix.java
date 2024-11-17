class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Check each diagonal starting from the first row
        for (int col = 0; col < n; col++) {
            if (!checkDiagonal(matrix, 0, col)) {
                return false;
            }
        }
        
        // Check each diagonal starting from the first column (excluding first element to avoid redundancy)
        for (int row = 1; row < m; row++) {
            if (!checkDiagonal(matrix, row, 0)) {
                return false;
            }
        }
        
        return true;
    }
    
    // Helper method to check if a diagonal has the same elements
    private boolean checkDiagonal(int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        int m = matrix.length;
        int n = matrix[0].length;
        
        while (row < m && col < n) {
            if (matrix[row][col] != value) {
                return false;
            }
            row++;
            col++;
        }
        return true;
    }
}
