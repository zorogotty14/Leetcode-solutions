import java.util.*;

class Solution {
    public int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int totalWalls = 0;
        
        while (true) {
            // List of regions with their threatened cells and walls needed
            List<Set<Integer>> regions = new ArrayList<>();
            List<Set<Integer>> frontiers = new ArrayList<>();
            List<Integer> walls = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];
            
            // Identify all infected regions
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        Set<Integer> region = new HashSet<>();
                        Set<Integer> frontier = new HashSet<>();
                        int wallCount = dfs(isInfected, visited, i, j, region, frontier);
                        regions.add(region);
                        frontiers.add(frontier);
                        walls.add(wallCount);
                    }
                }
            }

            // No more regions to quarantine
            if (regions.isEmpty()) {
                break;
            }

            // Find the region that threatens the most uninfected cells
            int maxIndex = 0;
            for (int i = 0; i < frontiers.size(); i++) {
                if (frontiers.get(i).size() > frontiers.get(maxIndex).size()) {
                    maxIndex = i;
                }
            }

            // Add walls to contain the most dangerous region
            totalWalls += walls.get(maxIndex);

            // Quarantine the most dangerous region
            for (int pos : regions.get(maxIndex)) {
                int x = pos / n, y = pos % n;
                isInfected[x][y] = -1; // Mark as quarantined
            }

            // Spread the virus for other regions
            for (int i = 0; i < regions.size(); i++) {
                if (i == maxIndex) continue;
                for (int pos : frontiers.get(i)) {
                    int x = pos / n, y = pos % n;
                    isInfected[x][y] = 1; // Spread infection
                }
            }
        }
        
        return totalWalls;
    }

    private int dfs(int[][] isInfected, boolean[][] visited, int x, int y, Set<Integer> region, Set<Integer> frontier) {
        int m = isInfected.length, n = isInfected[0].length;
        int walls = 0;
        int[] directions = {-1, 0, 1, 0, -1};
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        region.add(x * n + y);
        
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            for (int d = 0; d < 4; d++) {
                int nx = cell[0] + directions[d], ny = cell[1] + directions[d + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (isInfected[nx][ny] == 0) {
                        // Threatened cell (needs a wall)
                        frontier.add(nx * n + ny);
                        walls++;
                    } else if (isInfected[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        stack.push(new int[]{nx, ny});
                        region.add(nx * n + ny);
                    }
                }
            }
        }
        
        return walls;
    }
}
