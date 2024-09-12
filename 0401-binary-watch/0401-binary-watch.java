import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        // Loop through all possible hours (0 to 11)
        for (int hour = 0; hour < 12; hour++) {
            // Loop through all possible minutes (0 to 59)
            for (int minute = 0; minute < 60; minute++) {
                // Count the number of set bits in both hour and minute
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    // If the total number of bits equals turnedOn, it's a valid time
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        
        return result;
    }
}
