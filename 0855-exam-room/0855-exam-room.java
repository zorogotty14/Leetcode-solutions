import java.util.*;

class ExamRoom {
    private TreeSet<Integer> occupiedSeats;
    private int n;

    public ExamRoom(int n) {
        this.n = n;
        this.occupiedSeats = new TreeSet<>();
    }
    
    public int seat() {
        int seat = 0;

        if (!occupiedSeats.isEmpty()) {
            // Maximum distance
            int maxDistance = occupiedSeats.first();
            Integer prev = null;

            for (int current : occupiedSeats) {
                if (prev != null) {
                    int distance = (current - prev) / 2;
                    if (distance > maxDistance) {
                        maxDistance = distance;
                        seat = prev + distance;
                    }
                }
                prev = current;
            }

            // Check distance from the last occupied seat to the end
            if (n - 1 - occupiedSeats.last() > maxDistance) {
                seat = n - 1;
            }
        }

        // Add the student to the occupied seats
        occupiedSeats.add(seat);
        return seat;
    }
    
    public void leave(int p) {
        occupiedSeats.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
