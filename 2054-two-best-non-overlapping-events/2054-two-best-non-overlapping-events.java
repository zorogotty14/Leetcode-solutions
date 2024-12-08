import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Step 1: Sort events by their end times
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        
        int n = events.length;
        int[] maxValues = new int[n];
        maxValues[0] = events[0][2];
        
        // Step 2: Precompute the max value up to each event
        for (int i = 1; i < n; i++) {
            maxValues[i] = Math.max(maxValues[i - 1], events[i][2]);
        }
        
        int maxSum = 0;
        
        // Step 3: Iterate through each event and calculate the max sum
        for (int i = 0; i < n; i++) {
            // Single event case
            maxSum = Math.max(maxSum, events[i][2]);
            
            // Binary search for the latest event that ends before the current event starts
            int left = 0, right = i - 1, bestIndex = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][1] < events[i][0]) { // Non-overlapping condition
                    bestIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            // If there's a valid non-overlapping event, update the max sum
            if (bestIndex != -1) {
                maxSum = Math.max(maxSum, events[i][2] + maxValues[bestIndex]);
            }
        }
        
        return maxSum;
    }
}
