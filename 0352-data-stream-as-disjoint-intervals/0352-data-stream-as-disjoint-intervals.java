import java.util.*;

class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int value) {
        // Check if this value is already part of an existing interval
        if (intervals.containsKey(value)) {
            return; // Already present as a start of an interval
        }

        // Find the interval right before and right after the value
        Integer lowerKey = intervals.floorKey(value); // Largest key <= value
        Integer higherKey = intervals.ceilingKey(value); // Smallest key >= value

        boolean canMergeLeft = (lowerKey != null && intervals.get(lowerKey) + 1 >= value);
        boolean canMergeRight = (higherKey != null && higherKey - 1 <= value);

        if (canMergeLeft && canMergeRight) {
            // Merge both left and right intervals
            int newStart = lowerKey;
            int newEnd = intervals.get(higherKey);
            intervals.put(newStart, newEnd); // Update the merged interval
            intervals.remove(higherKey); // Remove the right interval
        } else if (canMergeLeft) {
            // Extend the left interval
            intervals.put(lowerKey, Math.max(intervals.get(lowerKey), value));
        } else if (canMergeRight) {
            // Extend the right interval
            int end = intervals.get(higherKey);
            intervals.remove(higherKey); // Remove the existing higher interval
            intervals.put(value, end); // Create a new interval starting at value
        } else {
            // Create a new interval
            intervals.put(value, value);
        }
    }

    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }
        return result;
    }
}
