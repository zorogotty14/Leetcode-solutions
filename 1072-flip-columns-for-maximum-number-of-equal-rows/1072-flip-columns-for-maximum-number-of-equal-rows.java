import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();
        int maxRows = 0;

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            StringBuilder flippedPattern = new StringBuilder();

            // Normalize the row into relative patterns
            for (int value : row) {
                if (row[0] == 0) {
                    pattern.append(value); // Original pattern
                    flippedPattern.append(1 - value); // Flipped pattern
                } else {
                    pattern.append(1 - value); // Treat as flipped
                    flippedPattern.append(value); // Flipped of flipped is original
                }
            }

            // Convert to string keys
            String key = pattern.toString();

            // Increment the count of this normalized pattern
            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);

            // Update maximum rows
            maxRows = Math.max(maxRows, patternCount.get(key));
        }

        return maxRows;
    }
}
