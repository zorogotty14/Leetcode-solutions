import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    
    private List<int[]> bookings;
    private List<int[]> doubleBookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check if the new event overlaps with any double bookings
        for (int[] db : doubleBookings) {
            if (start < db[1] && end > db[0]) {
                // This would cause a triple booking
                return false;
            }
        }

        // Check for overlaps with regular bookings and add overlaps to doubleBookings
        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                // This would create a double booking
                int overlapStart = Math.max(start, booking[0]);
                int overlapEnd = Math.min(end, booking[1]);
                doubleBookings.add(new int[]{overlapStart, overlapEnd});
            }
        }

        // Add the event to regular bookings since it doesn't cause a triple booking
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
