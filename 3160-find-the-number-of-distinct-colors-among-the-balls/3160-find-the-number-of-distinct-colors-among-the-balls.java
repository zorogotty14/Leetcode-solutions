import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        Set<Integer> distinctColors = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // If ball already has a color, update it
            if (ballColor.containsKey(ball)) {
                int prevColor = ballColor.get(ball);

                // Reduce the count of the previous color
                colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                if (colorCount.get(prevColor) == 0) {
                    distinctColors.remove(prevColor);
                }
            }

            // Assign the new color to the ball
            ballColor.put(ball, color);

            // Update color count and distinct color set
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            distinctColors.add(color);

            // Store the result
            result[i] = distinctColors.size();
        }

        return result;
    }
}
