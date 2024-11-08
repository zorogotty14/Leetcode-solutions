import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> intervals = new ArrayList<>();  // Store intervals [start, end, height]
        List<Integer> result = new ArrayList<>();
        int maxHeight = 0;

        for (int[] position : positions) {
            int left = position[0];
            int sideLength = position[1];
            int right = left + sideLength;

            int baseHeight = 0;

            // Check for overlap with existing intervals and determine the height to build on
            for (int[] interval : intervals) {
                int start = interval[0], end = interval[1], height = interval[2];
                if (left < end && right > start) {  // Overlapping condition
                    baseHeight = Math.max(baseHeight, height);
                }
            }

            // Calculate new height
            int newHeight = baseHeight + sideLength;
            maxHeight = Math.max(maxHeight, newHeight);

            // Add the new interval
            intervals.add(new int[]{left, right, newHeight});
            result.add(maxHeight);
        }

        return result;
    }
}
