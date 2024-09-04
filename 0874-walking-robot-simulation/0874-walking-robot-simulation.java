import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: North, East, South, West
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, dir = 0;
        int maxDistSquared = 0;
        
        // Store obstacles in a set for quick look-up
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        for (int command : commands) {
            if (command == -2) {  // turn left
                dir = (dir + 3) % 4;
            } else if (command == -1) {  // turn right
                dir = (dir + 1) % 4;
            } else {
                // Move forward command units
                for (int i = 0; i < command; i++) {
                    int nextX = x + dirs[dir][0];
                    int nextY = y + dirs[dir][1];
                    
                    // Check if the next position is an obstacle
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;  // Stop moving if there's an obstacle
                    }
                    
                    // Update position
                    x = nextX;
                    y = nextY;
                    
                    // Update the maximum distance squared
                    maxDistSquared = Math.max(maxDistSquared, x * x + y * y);
                }
            }
        }
        
        return maxDistSquared;
    }
}
