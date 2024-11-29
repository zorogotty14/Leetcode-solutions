import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        // Step 1: Extract coordinates of all 1s in both images
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
            }
        }

        // Step 2: Count vector shifts
        Map<String, Integer> vectorCount = new HashMap<>();
        int maxOverlap = 0;

        for (int[] point1 : ones1) {
            for (int[] point2 : ones2) {
                // Calculate vector shift
                int dx = point2[0] - point1[0];
                int dy = point2[1] - point1[1];
                String vector = dx + "," + dy;

                // Count this vector
                vectorCount.put(vector, vectorCount.getOrDefault(vector, 0) + 1);
                maxOverlap = Math.max(maxOverlap, vectorCount.get(vector));
            }
        }

        return maxOverlap;
    }
}
