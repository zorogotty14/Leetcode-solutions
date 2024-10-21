import java.util.*;

class Solution {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 1) return trees;

        // Sort the points based on x-coordinate, and in case of a tie, by y-coordinate
        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<int[]> lowerHull = new ArrayList<>();
        List<int[]> upperHull = new ArrayList<>();

        // Build the lower hull
        for (int[] tree : trees) {
            while (lowerHull.size() >= 2 && orientation(lowerHull.get(lowerHull.size() - 2), lowerHull.get(lowerHull.size() - 1), tree) > 0) {
                lowerHull.remove(lowerHull.size() - 1);
            }
            lowerHull.add(tree);
        }

        // Build the upper hull
        for (int i = trees.length - 1; i >= 0; i--) {
            int[] tree = trees[i];
            while (upperHull.size() >= 2 && orientation(upperHull.get(upperHull.size() - 2), upperHull.get(upperHull.size() - 1), tree) > 0) {
                upperHull.remove(upperHull.size() - 1);
            }
            upperHull.add(tree);
        }

        // Remove the last point of each hull to avoid duplication
        lowerHull.remove(lowerHull.size() - 1);
        upperHull.remove(upperHull.size() - 1);

        // Combine both hulls
        Set<int[]> result = new HashSet<>(lowerHull);
        result.addAll(upperHull);

        // Convert the set to an array
        return result.toArray(new int[result.size()][]);
    }

    // Helper function to determine the orientation of three points (p, q, r)
    // Returns:
    // 0 -> p, q and r are collinear
    // >0 -> Clockwise turn
    // <0 -> Counter-clockwise turn
    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }
}
