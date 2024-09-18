import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort the intervals based on their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int nonOverlapCount = 1; // Count the first interval
        int end = intervals[0][1]; // End time of the last added interval

        for (int i = 1; i < intervals.length; i++) {
            // If the current interval does not overlap with the last added interval
            if (intervals[i][0] >= end) {
                nonOverlapCount++; // Include this interval
                end = intervals[i][1]; // Update the end time
            }
            // Else, the intervals overlap, so we skip the current interval
        }

        // The minimum number of intervals to remove is total intervals minus non-overlapping intervals
        return intervals.length - nonOverlapCount;
    }
}
