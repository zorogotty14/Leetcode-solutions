import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // If the matrix is too small, no water can be trapped.
        if (m <= 2 || n <= 2) return 0;

        // Min-heap to store the boundary cells.
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell[2]));
        
        // Visited array to mark processed cells.
        boolean[][] visited = new boolean[m][n];

        // Step 1: Add all boundary cells to the priority queue.
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        // Step 2: Process the cells in the priority queue
        int trappedWater = 0;
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], height = cell[2];

            // Explore all 4 neighboring cells
            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    // If the neighboring cell is lower, water can be trapped.
                    trappedWater += Math.max(0, height - heightMap[nx][ny]);
                    // Add the neighbor to the queue with the updated height, which is max of its height and the current boundary height.
                    pq.offer(new int[]{nx, ny, Math.max(height, heightMap[nx][ny])});
                }
            }
        }

        return trappedWater;
    }
}
