import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2; // Start labeling islands from 2
        int maxSize = 0;

        // Step 1: Label each island with a unique ID and calculate its size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId, directions);
                    islandSizes.put(islandId, size);
                    maxSize = Math.max(maxSize, size);
                    islandId++;
                }
            }
        }

        // Step 2: Evaluate each 0 for the largest possible island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    int potentialSize = 1; // Flipping this 0 to 1

                    // Check all 4 neighbors
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            int id = grid[ni][nj];
                            if (!uniqueIslands.contains(id)) {
                                potentialSize += islandSizes.get(id);
                                uniqueIslands.add(id);
                            }
                        }
                    }

                    maxSize = Math.max(maxSize, potentialSize);
                }
            }
        }

        return maxSize;
    }

    private int dfs(int[][] grid, int i, int j, int islandId, int[][] directions) {
        int n = grid.length;
        int size = 1;
        grid[i][j] = islandId;

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                size += dfs(grid, ni, nj, islandId, directions);
            }
        }

        return size;
    }
}
