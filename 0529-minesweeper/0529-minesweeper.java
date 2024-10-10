class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        
        // Case 1: If we click on a mine, change it to 'X'
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        
        // Case 2: If we click on an empty square 'E', start the DFS
        dfs(board, row, col);
        
        return board;
    }
    
    private void dfs(char[][] board, int row, int col) {
        // If out of bounds or if this is already revealed, return
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'E') {
            return;
        }
        
        // Count the number of adjacent mines
        int mineCount = countAdjacentMines(board, row, col);
        
        if (mineCount > 0) {
            // If there are adjacent mines, reveal the number
            board[row][col] = (char) (mineCount + '0');
        } else {
            // No adjacent mines, mark this square as 'B' and recurse for all neighbors
            board[row][col] = 'B';
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                dfs(board, newRow, newCol);
            }
        }
    }
    
    // Helper function to count adjacent mines
    private int countAdjacentMines(char[][] board, int row, int col) {
        int mineCount = 0;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] == 'M') {
                mineCount++;
            }
        }
        return mineCount;
    }
}
