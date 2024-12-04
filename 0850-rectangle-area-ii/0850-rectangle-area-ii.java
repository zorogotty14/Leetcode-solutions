import java.util.*;

class Solution {
    public int rectangleArea(int[][] rectangles) {
        final int MOD = 1_000_000_007;

        // Collect all unique x-coordinates
        TreeSet<Integer> xSet = new TreeSet<>();
        for (int[] rect : rectangles) {
            xSet.add(rect[0]);
            xSet.add(rect[2]);
        }

        // Convert x-coordinates to a list and create a mapping
        List<Integer> xList = new ArrayList<>(xSet);
        Map<Integer, Integer> xMap = new HashMap<>();
        for (int i = 0; i < xList.size(); i++) {
            xMap.put(xList.get(i), i);
        }

        // Create a list of events (y, xStart, xEnd, delta)
        List<int[]> events = new ArrayList<>();
        for (int[] rect : rectangles) {
            events.add(new int[]{rect[1], rect[0], rect[2], 1});  // Add event
            events.add(new int[]{rect[3], rect[0], rect[2], -1}); // Remove event
        }

        // Sort events by y-coordinate
        events.sort((a, b) -> a[0] - b[0]);

        long area = 0;
        int[] count = new int[xList.size() - 1]; // Active count of rectangles for each segment
        long prevY = events.get(0)[0];

        // Process events
        for (int i = 0; i < events.size(); i++) {
            int[] event = events.get(i);
            int y = event[0], x1 = event[1], x2 = event[2], delta = event[3];

            // Calculate the active width
            long width = 0;
            for (int j = 0; j < count.length; j++) {
                if (count[j] > 0) {
                    width += xList.get(j + 1) - xList.get(j);
                }
            }

            // Update the area
            area = (area + width * (y - prevY)) % MOD;

            // Update the count array for the current event
            for (int j = xMap.get(x1); j < xMap.get(x2); j++) {
                count[j] += delta;
            }

            prevY = y;
        }

        return (int) area;
    }
}
