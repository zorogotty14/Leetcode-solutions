import java.util.TreeMap;

class RangeModule {
    private TreeMap<Integer, Integer> intervals;

    public RangeModule() {
        intervals = new TreeMap<>();
    }

    // Adds a range [left, right) to be tracked
    public void addRange(int left, int right) {
        // Merge overlapping or adjacent intervals
        Integer start = intervals.floorKey(left);
        if (start != null && intervals.get(start) >= left) {
            left = start;
            right = Math.max(right, intervals.get(start));
            intervals.remove(start);
        }

        Integer next = intervals.ceilingKey(left);
        while (next != null && next <= right) {
            right = Math.max(right, intervals.get(next));
            intervals.remove(next);
            next = intervals.ceilingKey(left);
        }

        intervals.put(left, right);
    }

    // Queries whether the range [left, right) is completely covered
    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        return start != null && intervals.get(start) >= right;
    }

    // Removes the range [left, right) from tracking
    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if (start != null && intervals.get(start) > left) {
            int end = intervals.get(start);
            intervals.remove(start);
            if (start < left) {
                intervals.put(start, left);
            }
            if (end > right) {
                intervals.put(right, end);
            }
        }

        Integer next = intervals.ceilingKey(left);
        while (next != null && next < right) {
            int end = intervals.get(next);
            intervals.remove(next);
            if (end > right) {
                intervals.put(right, end);
                break;
            }
            next = intervals.ceilingKey(left);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
