class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n]; // columns   |
        boolean[] d1 = new boolean[2 * n]; // diagonals \
        boolean[] d2 = new boolean[2 * n]; // diagonals /
        backtrack(0, n, cols, d1, d2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n; // index for d1
            int id2 = col + row;     // index for d2
            if (cols[col] || d1[id1] || d2[id2]) continue;
            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtrack(row + 1, n, cols, d1, d2);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}