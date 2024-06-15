class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Directions array for the 8 neighbors (top-left, top, top-right, left, right, bottom-left, bottom, bottom-right)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},         {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        // Create a copy of the original board to reference neighbor states
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }

        // Compute the next state for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int[] direction : directions) {
                    int newRow = i + direction[0];
                    int newCol = j + direction[1];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && copy[newRow][newCol] == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply the rules
                if (copy[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 0; // Rule 1 and Rule 3
                } else if (copy[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 1; // Rule 4
                }
                // Rule 2 is already satisfied, so no change is needed for copy[i][j] == 1 and (liveNeighbors == 2 || liveNeighbors == 3)
            }
        }
    }
}