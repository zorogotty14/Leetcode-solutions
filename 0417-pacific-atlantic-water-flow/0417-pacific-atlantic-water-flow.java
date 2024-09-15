import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Perform DFS for each cell adjacent to the Pacific and Atlantic oceans
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0); // Pacific (left border)
            dfs(heights, atlantic, i, n - 1); // Atlantic (right border)
        }
        
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j); // Pacific (top border)
            dfs(heights, atlantic, m - 1, j); // Atlantic (bottom border)
        }
        
        // Collect cells that can flow to both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] ocean, int i, int j) {
        ocean[i][j] = true;
        
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            
            if (newI >= 0 && newI < heights.length && newJ >= 0 && newJ < heights[0].length
                && !ocean[newI][newJ] && heights[newI][newJ] >= heights[i][j]) {
                dfs(heights, ocean, newI, newJ);
            }
        }
    }
}
