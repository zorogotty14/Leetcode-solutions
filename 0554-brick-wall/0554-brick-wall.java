import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCount = new HashMap<>();
        int maxEdges = 0;

        // Traverse each row in the wall
        for (List<Integer> row : wall) {
            int sum = 0; // Track cumulative sum of brick widths
            
            // Exclude the last brick in the row to avoid placing the line at the far right edge
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                
                // Count how many times this edge occurs across rows
                edgeCount.put(sum, edgeCount.getOrDefault(sum, 0) + 1);
                
                // Track the maximum edge frequency
                maxEdges = Math.max(maxEdges, edgeCount.get(sum));
            }
        }

        // The result is the total number of rows minus the max edge frequency
        return wall.size() - maxEdges;
    }
}
