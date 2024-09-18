import java.util.Arrays;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        // Create an array to store the start times and their original indices
        int[][] starts = new int[n][2]; // [starti, indexi]
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0]; // starti
            starts[i][1] = i;               // original index
        }

        // Sort the starts array based on start times
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));

        // For each interval, find the minimal startj >= endi
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1]; // endi
            int index = binarySearch(starts, end);
            result[i] = index;
        }

        return result;
    }

    // Custom binary search to find minimal startj >= target
    private int binarySearch(int[][] starts, int target) {
        int left = 0;
        int right = starts.length - 1;
        int index = -1; // Default value if no right interval is found

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (starts[mid][0] >= target) {
                index = starts[mid][1]; // Potential candidate
                right = mid - 1;        // Try to find a smaller startj
            } else {
                left = mid + 1;
            }
        }

        return index;
    }
}
