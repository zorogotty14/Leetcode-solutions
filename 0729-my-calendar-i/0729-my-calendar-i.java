import java.util.ArrayList;
import java.util.List;

class MyCalendar {

    private List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check for overlaps with existing events
        for (int[] event : calendar) {
            int bookedStart = event[0];
            int bookedEnd = event[1];
            // If the new event overlaps with any existing event, return false
            if (Math.max(start, bookedStart) < Math.min(end, bookedEnd)) {
                return false;
            }
        }
        // If no overlap is found, add the event and return true
        calendar.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
