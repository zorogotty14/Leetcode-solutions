class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;

        // Iterate through all combinations of three points
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    // Calculate the area of the triangle formed by points[i], points[j], points[k]
                    double area = calculateArea(points[i], points[j], points[k]);
                    // Update the maximum area if this one is larger
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    // Helper function to calculate the area of a triangle using the determinant method
    private double calculateArea(int[] p1, int[] p2, int[] p3) {
        return Math.abs(
            0.5 * (p1[0] * (p2[1] - p3[1]) +
                   p2[0] * (p3[1] - p1[1]) +
                   p3[0] * (p1[1] - p2[1]))
        );
    }
}
