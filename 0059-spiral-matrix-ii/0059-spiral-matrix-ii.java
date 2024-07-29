class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // Fill from left to right across the top boundary
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++; // Move the top boundary down

            // Fill from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--; // Move the right boundary left

            if (top <= bottom) {
                // Fill from right to left across the bottom boundary
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = value++;
                }
                bottom--; // Move the bottom boundary up
            }

            if (left <= right) {
                // Fill from bottom to top along the left boundary
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value++;
                }
                left++; // Move the left boundary right
            }
        }

        return matrix;
    }
}