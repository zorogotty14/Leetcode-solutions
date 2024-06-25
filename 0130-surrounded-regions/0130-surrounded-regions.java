class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Step 1: Mark all non-surrounded regions
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                markNonSurrounded(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                markNonSurrounded(board, i, cols - 1);
            }
        }
        
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                markNonSurrounded(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                markNonSurrounded(board, rows - 1, j);
            }
        }
        
        // Step 2: Capture surrounded regions and restore non-surrounded regions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void markNonSurrounded(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;
        
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
            return;
        }
        
        board[i][j] = 'T';  // Mark as non-surrounded
        
        markNonSurrounded(board, i - 1, j); // Up
        markNonSurrounded(board, i + 1, j); // Down
        markNonSurrounded(board, i, j - 1); // Left
        markNonSurrounded(board, i, j + 1); // Right
    }
}