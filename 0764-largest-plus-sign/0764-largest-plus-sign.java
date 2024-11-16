import java.util.HashSet;
import java.util.Set;

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // Create a grid filled with 1s
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }
        
        // Set cells in the grid to 0 based on the given mines
        Set<Integer> mineSet = new HashSet<>();
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
            mineSet.add(mine[0] * n + mine[1]);
        }

        // DP arrays to keep track of arm lengths
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];

        int maxOrder = 0;

        // Populate DP arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Left
                if (grid[i][j] == 1) {
                    left[i][j] = (j == 0 ? 1 : left[i][j - 1] + 1);
                }
                // Up
                if (grid[j][i] == 1) {
                    up[j][i] = (j == 0 ? 1 : up[j - 1][i] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Right
                if (grid[i][j] == 1) {
                    right[i][j] = (j == n - 1 ? 1 : right[i][j + 1] + 1);
                }
                // Down
                if (grid[j][i] == 1) {
                    down[j][i] = (j == n - 1 ? 1 : down[j + 1][i] + 1);
                }
            }
        }

        // Calculate the order of the largest plus sign
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int order = Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j]));
                    maxOrder = Math.max(maxOrder, order);
                }
            }
        }

        return maxOrder;
    }
}
