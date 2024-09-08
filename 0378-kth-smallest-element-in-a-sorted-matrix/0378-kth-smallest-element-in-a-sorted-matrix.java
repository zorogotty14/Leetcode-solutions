class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        // Define the binary search range
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Count how many numbers are less than or equal to mid
            int count = countLessEqual(matrix, mid, n);
            
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low; // or return high, as low and high will converge
    }
    
    // Helper function to count how many numbers are <= target in the matrix
    private int countLessEqual(int[][] matrix, int target, int n) {
        int count = 0;
        int row = n - 1; // start from the last row
        int col = 0;     // start from the first column
        
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row + 1; // All elements in this column up to this row are <= target
                col++;            // Move right to the next column
            } else {
                row--;            // Move up to the next smaller element
            }
        }
        
        return count;
    }
}
