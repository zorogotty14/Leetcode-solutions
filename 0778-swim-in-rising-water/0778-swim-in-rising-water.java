import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // Min-heap based on elevation/time
        pq.offer(new int[]{0, 0, grid[0][0]}); // Starting at (0, 0) with initial elevation time
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], time = current[2];

            // If we have reached the bottom-right corner
            if (x == n - 1 && y == n - 1) {
                return time;
            }

            // Mark the current cell as visited
            visited[x][y] = true;

            // Explore the 4-directionally adjacent cells
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < n && newY < n && !visited[newX][newY]) {
                    // The time to move to the next cell is the max of the current time or the elevation of the next cell
                    pq.offer(new int[]{newX, newY, Math.max(time, grid[newX][newY])});
                }
            }
        }

        return -1; // Should never reach here as per the problem constraints
    }
}
