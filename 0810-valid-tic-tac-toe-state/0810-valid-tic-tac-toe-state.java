class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        
        // Count 'X' and 'O' in the board
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }
        }
        
        // Rule 1: X must play first, so xCount >= oCount
        // Rule 2: X can only be at most one more than O
        if (xCount < oCount || xCount > oCount + 1) {
            return false;
        }
        
        // Check if X or O has won
        boolean xWin = hasWon(board, 'X');
        boolean oWin = hasWon(board, 'O');
        
        // Rule 3: Both X and O cannot win simultaneously
        if (xWin && oWin) {
            return false;
        }
        
        // Rule 4: If X wins, xCount must be exactly one more than oCount
        if (xWin && xCount != oCount + 1) {
            return false;
        }
        
        // Rule 5: If O wins, xCount must be equal to oCount
        if (oWin && xCount != oCount) {
            return false;
        }
        
        return true;
    }
    
    private boolean hasWon(String[] board, char player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
            // Check columns
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true;
        }
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true;
        }
        return false;
    }
}
