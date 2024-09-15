class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        
        // Traverse through the entire board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the current cell is 'X'
                if (board[i][j] == 'X') {
                    // Count only if it is the top-left of a battleship
                    // (i.e., no 'X' above it and no 'X' to the left of it)
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue; // Skip if there is a battleship part above
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue; // Skip if there is a battleship part to the left
                    }
                    count++; // This is the top-left of a battleship
                }
            }
        }
        
        return count;
    }
}
