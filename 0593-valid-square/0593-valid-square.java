import java.util.*;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // Compute the squared distances between all six pairs of points
        List<Integer> distances = new ArrayList<>();
        distances.add(distanceSquared(p1, p2));
        distances.add(distanceSquared(p1, p3));
        distances.add(distanceSquared(p1, p4));
        distances.add(distanceSquared(p2, p3));
        distances.add(distanceSquared(p2, p4));
        distances.add(distanceSquared(p3, p4));

        // Use a set to find the unique distances
        Set<Integer> uniqueDistances = new HashSet<>(distances);

        // A valid square must have exactly 2 unique distances (side and diagonal)
        if (uniqueDistances.size() != 2) return false;

        // Get the frequency of each distance
        int sideLength = Collections.min(uniqueDistances);
        int diagonalLength = Collections.max(uniqueDistances);

        // Verify that the side length occurs 4 times and diagonal length occurs 2 times
        int sideCount = 0, diagonalCount = 0;
        for (int dist : distances) {
            if (dist == sideLength) sideCount++;
            else if (dist == diagonalLength) diagonalCount++;
        }

        return sideCount == 4 && diagonalCount == 2;
    }

    // Helper method to calculate the squared distance between two points
    private int distanceSquared(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}
