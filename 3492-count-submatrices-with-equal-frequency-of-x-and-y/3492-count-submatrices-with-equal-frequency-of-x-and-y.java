class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prefixX = new int[m + 1][n + 1];
        int[][] prefixY = new int[m + 1][n + 1];

        // Build prefix sums for 'X' and 'Y'
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixX[i][j] = prefixX[i - 1][j] + prefixX[i][j - 1] - prefixX[i - 1][j - 1];
                prefixY[i][j] = prefixY[i - 1][j] + prefixY[i][j - 1] - prefixY[i - 1][j - 1];

                if (grid[i - 1][j - 1] == 'X') {
                    prefixX[i][j]++;
                } else if (grid[i - 1][j - 1] == 'Y') {
                    prefixY[i][j]++;
                }
            }
        }

        int count = 0;

        // Iterate over all possible submatrices starting from (0, 0)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int xCount = prefixX[i][j];
                int yCount = prefixY[i][j];

                if (xCount == yCount && xCount > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}