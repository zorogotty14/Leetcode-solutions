import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Sort both arrays
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int radius = 0;
        
        // For each house, find the closest heater
        for (int house : houses) {
            // Use binary search to find the closest heater
            int idx = Arrays.binarySearch(heaters, house);
            
            if (idx < 0) {
                // If the house isn't exactly on a heater, binarySearch returns (-insertion_point - 1)
                idx = -(idx + 1);
                
                // Find the nearest distance to the left or right heater
                int dist1 = (idx > 0) ? house - heaters[idx - 1] : Integer.MAX_VALUE;
                int dist2 = (idx < heaters.length) ? heaters[idx] - house : Integer.MAX_VALUE;
                
                // Take the minimum of both distances
                int minDist = Math.min(dist1, dist2);
                // Track the maximum minimum distance (this is the minimum radius needed)
                radius = Math.max(radius, minDist);
            }
        }
        
        return radius;
    }
}
