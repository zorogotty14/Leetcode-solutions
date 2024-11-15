import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort intervals primarily by end points in ascending order
        // If end points are the same, sort by starting points in descending order
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));

        // Keep track of the two largest elements required to cover previous intervals
        int count = 0;
        int largest = -1, secondLargest = -1;

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];

            // If the interval is not covered by the current two elements
            if (start > largest) {
                // We need to add two new elements
                count += 2;
                largest = end;
                secondLargest = end - 1;
            } else if (start > secondLargest) {
                // We need to add one new element
                count += 1;
                secondLargest = largest;
                largest = end;
            }
        }

        return count;
    }
}
