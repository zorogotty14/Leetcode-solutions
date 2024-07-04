class Solution {
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        
        int maxPoints = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int overlap = 0;
            int currentMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];
                
                if (deltaX == 0 && deltaY == 0) {
                    overlap++;
                    continue;
                }

                int gcd = gcd(deltaX, deltaY);
                deltaX /= gcd;
                deltaY /= gcd;

                // Ensure the slope is unique and comparable (handle negative signs)
                if (deltaX < 0) {
                    deltaX = -deltaX;
                    deltaY = -deltaY;
                } else if (deltaX == 0) {
                    deltaY = Math.abs(deltaY); // For vertical lines
                }

                String slope = deltaX + "/" + deltaY;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                currentMax = Math.max(currentMax, slopeMap.get(slope));
            }

            maxPoints = Math.max(maxPoints, currentMax + overlap + 1);
        }
        
        return maxPoints;
    }
}