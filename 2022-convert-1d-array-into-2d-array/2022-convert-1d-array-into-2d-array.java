class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if the total elements in original match the required elements for the 2D array
        if (original.length != m * n) {
            return new int[0][0]; // Return an empty 2D array if it's not possible
        }

        // Initialize the 2D array with the given dimensions
        int[][] result = new int[m][n];

        // Fill the 2D array with elements from the original array
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }

        return result;
    }
}