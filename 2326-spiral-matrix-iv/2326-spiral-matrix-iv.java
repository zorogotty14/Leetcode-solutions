class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Step 1: Initialize the matrix with -1
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        
        // Step 2: Set the boundaries for the spiral traversal
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        ListNode current = head;
        
        // Step 3: Start the spiral traversal
        while (current != null) {
            // Traverse from left to right (top row)
            for (int col = left; col <= right && current != null; col++) {
                matrix[top][col] = current.val;
                current = current.next;
            }
            top++;  // Move the top boundary down
            
            // Traverse from top to bottom (right column)
            for (int row = top; row <= bottom && current != null; row++) {
                matrix[row][right] = current.val;
                current = current.next;
            }
            right--;  // Move the right boundary left
            
            // Traverse from right to left (bottom row)
            for (int col = right; col >= left && current != null; col--) {
                matrix[bottom][col] = current.val;
                current = current.next;
            }
            bottom--;  // Move the bottom boundary up
            
            // Traverse from bottom to top (left column)
            for (int row = bottom; row >= top && current != null; row--) {
                matrix[row][left] = current.val;
                current = current.next;
            }
            left++;  // Move the left boundary right
        }
        
        // Step 4: Return the filled matrix
        return matrix;
    }
}
