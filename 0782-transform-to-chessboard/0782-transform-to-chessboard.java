class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;

        // Check if the board can potentially be transformed into a chessboard
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }

        int rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;

        // Count rows and columns
        for (int i = 0; i < n; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] == i % 2) rowSwap++;
            if (board[0][i] == i % 2) colSwap++;
        }

        // Check if rows/columns have valid numbers of 0s and 1s
        if (rowSum < n / 2 || rowSum > (n + 1) / 2) return -1;
        if (colSum < n / 2 || colSum > (n + 1) / 2) return -1;

        // Calculate minimum swaps
        if (n % 2 == 0) {
            rowSwap = Math.min(rowSwap, n - rowSwap);
            colSwap = Math.min(colSwap, n - colSwap);
        } else {
            if (rowSwap % 2 == 1) rowSwap = n - rowSwap;
            if (colSwap % 2 == 1) colSwap = n - colSwap;
        }

        return (rowSwap + colSwap) / 2;
    }
}
