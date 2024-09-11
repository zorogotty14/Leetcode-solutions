import java.util.HashSet;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        // Variables to track the bounding rectangle
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        // Total area covered by all the rectangles
        int totalArea = 0;
        
        // HashSet to store the corners
        HashSet<String> cornerSet = new HashSet<>();
        
        for (int[] rect : rectangles) {
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];
            
            // Update bounding rectangle
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);
            
            // Add the area of the current rectangle
            totalArea += (x2 - x1) * (y2 - y1);
            
            // Encode the corner points as strings and toggle them in the set
            String[] corners = {
                x1 + " " + y1, // bottom-left
                x1 + " " + y2, // top-left
                x2 + " " + y1, // bottom-right
                x2 + " " + y2  // top-right
            };
            
            for (String corner : corners) {
                if (!cornerSet.add(corner)) {
                    cornerSet.remove(corner); // If it's already present, remove it (toggle)
                }
            }
        }
        
        // The expected four corners of the bounding rectangle
        String[] expectedCorners = {
            minX + " " + minY, // bottom-left
            minX + " " + maxY, // top-left
            maxX + " " + minY, // bottom-right
            maxX + " " + maxY  // top-right
        };
        
        // Check if the corner set contains exactly the four corners of the bounding rectangle
        for (String corner : expectedCorners) {
            if (!cornerSet.remove(corner)) {
                return false; // Missing expected corner
            }
        }
        
        // The set should be empty after removing the four bounding corners
        if (!cornerSet.isEmpty()) {
            return false; // Extra corner points, meaning gaps or overlaps
        }
        
        // Check if the total area matches the area of the bounding rectangle
        int boundingArea = (maxX - minX) * (maxY - minY);
        return totalArea == boundingArea;
    }
}
