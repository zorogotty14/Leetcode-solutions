import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        
        // Step 1: Collect all trees with their heights and positions
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = forest.get(i).get(j);
                if (height > 1) {
                    trees.add(new int[]{height, i, j});
                }
            }
        }
        
        // Step 2: Sort trees by height
        trees.sort(Comparator.comparingInt(a -> a[0]));
        
        // Step 3: Initialize start position and total steps
        int totalSteps = 0;
        int startX = 0, startY = 0;
        
        // Step 4: Calculate the shortest path to each tree in sorted order
        for (int[] tree : trees) {
            int targetX = tree[1];
            int targetY = tree[2];
            int steps = bfs(forest, startX, startY, targetX, targetY);
            
            if (steps == -1) {
                return -1; // If a tree is unreachable, return -1
            }
            
            totalSteps += steps;
            startX = targetX;
            startY = targetY;
        }
        
        return totalSteps;
    }
    
    // BFS to find the shortest path from (startX, startY) to (targetX, targetY)
    private int bfs(List<List<Integer>> forest, int startX, int startY, int targetX, int targetY) {
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startX, startY, 0});  // (x, y, steps)
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], steps = curr[2];
            
            // If we reach the target, return the number of steps
            if (x == targetX && y == targetY) {
                return steps;
            }
            
            // Explore the four possible directions
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n &&
                    !visited[newX][newY] && forest.get(newX).get(newY) > 0) {
                    queue.offer(new int[]{newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }
        
        // Return -1 if the target is unreachable
        return -1;
    }
}
