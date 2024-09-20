import java.util.HashMap;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        int n = points.length;

        // Iterate over each point 'i' in the list
        for (int i = 0; i < n; i++) {
            // Map to store frequency of distances from point 'i' to others
            HashMap<Integer, Integer> distanceCount = new HashMap<>();

            // Compute distances from point 'i' to all other points 'j'
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                // Use squared distance to avoid floating point operations
                int distanceSquared = dx * dx + dy * dy;

                // Update the count of this distance
                distanceCount.put(distanceSquared, distanceCount.getOrDefault(distanceSquared, 0) + 1);
            }

            // For each distance, calculate the number of boomerangs
            for (int count : distanceCount.values()) {
                // If there are 'count' points at this distance,
                // there are count * (count - 1) permutations
                result += count * (count - 1);
            }
        }

        return result;
    }
}
