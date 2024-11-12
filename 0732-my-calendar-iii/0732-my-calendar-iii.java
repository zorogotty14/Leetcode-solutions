import java.util.TreeMap;

class MyCalendarThree {
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        // Increment count at start time and decrement at end time
        timeline.put(startTime, timeline.getOrDefault(startTime, 0) + 1);
        timeline.put(endTime, timeline.getOrDefault(endTime, 0) - 1);
        
        int activeBookings = 0;
        int maxBookings = 0;
        
        // Traverse the timeline to find the maximum number of active bookings
        for (int count : timeline.values()) {
            activeBookings += count;
            maxBookings = Math.max(maxBookings, activeBookings);
        }
        
        return maxBookings;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
