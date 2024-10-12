import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        
        // Create events for start and end of intervals
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});    // Start of interval
            events.add(new int[]{interval[1] + 1, -1}); // End of interval (+1 to handle inclusive ends)
        }
        
        // Sort events: by time first, then by type of event (start before end)
        Collections.sort(events, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        
        int currentGroups = 0;
        int maxGroups = 0;
        
        // Sweep through the events
        for (int[] event : events) {
            currentGroups += event[1]; // Add 1 for start, subtract 1 for end
            maxGroups = Math.max(maxGroups, currentGroups);
        }
        
        return maxGroups;
    }
}
