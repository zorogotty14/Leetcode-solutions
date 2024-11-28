import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] cost = new int[m][n];
        
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // cost, row, col
        cost[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int x = current[1];
            int y = current[2];
            
            // If we've reached the target
            if (x == m - 1 && y == n - 1) {
                return currentCost;
            }
            
            // Explore neighbors
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newCost = currentCost + grid[nx][ny];
                    
                    // Only update if we find a better cost
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        pq.offer(new int[]{newCost, nx, ny});
                    }
                }
            }
        }
        
        return -1; // Should never reach here since a path always exists
    }
}
