import java.util.*;

class Solution {
    private int[][] rects;
    private List<Integer> cumulativePoints;
    private Random rand;
    private int totalPoints;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.cumulativePoints = new ArrayList<>();
        this.rand = new Random();
        this.totalPoints = 0;

        // Calculate the number of points in each rectangle and store cumulative sums
        for (int[] rect : rects) {
            int pointsInRect = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            totalPoints += pointsInRect;
            cumulativePoints.add(totalPoints);
        }
    }

    public int[] pick() {
        // Randomly choose a point index in the range [1, totalPoints]
        int pointIndex = rand.nextInt(totalPoints) + 1;

        // Find which rectangle this point belongs to using binary search
        int rectIndex = binarySearch(pointIndex);

        // Get the corresponding rectangle
        int[] rect = rects[rectIndex];
        int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];

        // Randomly select a point inside the chosen rectangle
        int x = rand.nextInt(x2 - x1 + 1) + x1;
        int y = rand.nextInt(y2 - y1 + 1) + y1;

        return new int[] {x, y};
    }

    private int binarySearch(int pointIndex) {
        int left = 0, right = cumulativePoints.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (cumulativePoints.get(mid) < pointIndex) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
