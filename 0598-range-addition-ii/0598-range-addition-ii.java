class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        // Initialize the minimum dimensions to the full matrix size
        int minRow = m;
        int minCol = n;

        // Find the minimum ai and bi across all operations
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        // The maximum value will appear in a submatrix of size minRow * minCol
        return minRow * minCol;
    }
}
