import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Directions array for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Initialize a queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the distance matrix and add all '0' positions to the queue
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    // Mark the distance for 1's as infinity (we'll update them later)
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // Perform BFS from all the '0' cells
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            
            // Explore neighbors in the 4 directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check if the new position is within bounds and needs updating
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    if (dist[newRow][newCol] > dist[row][col] + 1) {
                        // Update the distance and add the cell to the queue
                        dist[newRow][newCol] = dist[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        
        return dist;
    }
}
