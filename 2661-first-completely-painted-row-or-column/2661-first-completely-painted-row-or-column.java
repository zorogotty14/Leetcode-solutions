class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;  // Number of rows
        int n = mat[0].length;  // Number of columns

        // Step 1: Map mat values to their positions
        Map<Integer, int[]> valueToPosition = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valueToPosition.put(mat[i][j], new int[]{i, j});
            }
        }

        // Step 2: Arrays to track painted rows and columns
        int[] rowPainted = new int[m];
        int[] colPainted = new int[n];

        // Step 3: Process the array `arr`
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int[] position = valueToPosition.get(value);
            int row = position[0];
            int col = position[1];

            // Paint the cell
            rowPainted[row]++;
            colPainted[col]++;

            // Check if row or column is fully painted
            if (rowPainted[row] == n || colPainted[col] == m) {
                return i;
            }
        }

        // This point should never be reached given the constraints
        return -1;
    }
}
