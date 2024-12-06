import java.util.*;

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        
        // Initialize variables for BFS
        int allKeys = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        // Locate the starting position and calculate bitmask for all keys
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    queue.add(new int[]{i, j, 0}); // Start BFS with no keys
                    visited.add(i + "," + j + ",0");
                } else if (c >= 'a' && c <= 'f') {
                    allKeys |= (1 << (c - 'a')); // Add the key to the bitmask
                }
            }
        }
        
        // Directions for moving in the grid
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int steps = 0;
        
        // BFS to find the shortest path
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1], keys = current[2];
                
                // If we have all keys, return the number of steps
                if (keys == allKeys) {
                    return steps;
                }
                
                // Explore neighbors
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    int newKeys = keys;
                    
                    // Check bounds
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }
                    
                    char c = grid[nx].charAt(ny);
                    
                    // If it's a wall, skip
                    if (c == '#') {
                        continue;
                    }
                    
                    // If it's a key, pick it up
                    if (c >= 'a' && c <= 'f') {
                        newKeys |= (1 << (c - 'a'));
                    }
                    
                    // If it's a lock, check if we have the corresponding key
                    if (c >= 'A' && c <= 'F' && (newKeys & (1 << (c - 'A'))) == 0) {
                        continue;
                    }
                    
                    // Avoid revisiting the same state
                    String state = nx + "," + ny + "," + newKeys;
                    if (!visited.contains(state)) {
                        visited.add(state);
                        queue.add(new int[]{nx, ny, newKeys});
                    }
                }
            }
            steps++;
        }
        
        // If we exhaust the queue without finding all keys, return -1
        return -1;
    }
}
