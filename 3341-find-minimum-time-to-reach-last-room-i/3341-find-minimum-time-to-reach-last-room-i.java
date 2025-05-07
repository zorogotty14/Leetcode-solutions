class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        
        // Initialize distance array with maximum possible value
        int[][] minTime = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // Starting point
        minTime[0][0] = 0;
        
        // Define directions: up, right, down, left
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // Queue for BFS - stores [row, col, current time]
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            
            // Skip if we've found a better path
            if (time > minTime[row][col]) {
                continue;
            }
            
            // Check all adjacent rooms
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check if the new position is valid
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    // Calculate the time to move to the next room
                    int nextTime = Math.max(time, moveTime[newRow][newCol]) + 1;
                    
                    // Update if we found a better path
                    if (nextTime < minTime[newRow][newCol]) {
                        minTime[newRow][newCol] = nextTime;
                        queue.offer(new int[]{newRow, newCol, nextTime});
                    }
                }
            }
        }
        
        return minTime[n-1][m-1];
    }
}