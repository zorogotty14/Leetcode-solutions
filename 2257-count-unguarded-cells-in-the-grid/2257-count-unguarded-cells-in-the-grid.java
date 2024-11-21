import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Set to keep track of guarded cells
        Set<String> guarded = new HashSet<>();
        // Set to keep track of blocked cells (guards and walls)
        Set<String> blocked = new HashSet<>();

        // Mark all guard and wall positions as blocked
        for (int[] guard : guards) {
            blocked.add(key(guard[0], guard[1]));
        }
        for (int[] wall : walls) {
            blocked.add(key(wall[0], wall[1]));
        }

        // Directions for north, south, east, west
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Mark cells guarded by each guard
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                // Continue marking until a wall or another guard is encountered
                while (r >= 0 && r < m && c >= 0 && c < n && !blocked.contains(key(r, c))) {
                    guarded.add(key(r, c));
                    r += dir[0];
                    c += dir[1];
                }
            }
        }

        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String cell = key(i, j);
                if (!blocked.contains(cell) && !guarded.contains(cell)) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }

    // Helper function to generate a unique key for each cell
    private String key(int row, int col) {
        return row + "," + col;
    }
}
