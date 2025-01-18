import java.util.PriorityQueue;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Directions mapping
        int[][] directions = {
            {0, 1},  // 1 -> Right
            {0, -1}, // 2 -> Left
            {1, 0},  // 3 -> Down
            {-1, 0}  // 4 -> Up
        };
        
        // Visited array
        boolean[][] visited = new boolean[m][n];
        
        // Priority queue for BFS
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // Min-heap
        pq.offer(new int[]{0, 0, 0}); // {cost, x, y}
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];
            
            // If already visited, skip
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            
            // If we reach the bottom-right corner, return the cost
            if (x == m - 1 && y == n - 1) {
                return cost;
            }
            
            // Explore all directions
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    // Check if the current direction matches the grid's direction
                    int newCost = cost + (grid[x][y] == i + 1 ? 0 : 1);
                    pq.offer(new int[]{newCost, nx, ny});
                }
            }
        }
        
        return -1; // Should not reach here
    }
}
