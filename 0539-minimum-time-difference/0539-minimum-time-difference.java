import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // Step 1: Convert timePoints to a list of minutes
        List<Integer> minutesList = new ArrayList<>();
        
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int totalMinutes = hours * 60 + minutes;
            minutesList.add(totalMinutes);
        }
        
        // Step 2: Sort the list of minutes
        Collections.sort(minutesList);
        
        // Step 3: Initialize the minimum difference to a large value
        int minDifference = Integer.MAX_VALUE;
        
        // Step 4: Find the minimum difference between consecutive time points
        for (int i = 1; i < minutesList.size(); i++) {
            minDifference = Math.min(minDifference, minutesList.get(i) - minutesList.get(i - 1));
        }
        
        // Step 5: Handle the circular case (difference between the first and last time point)
        int wrapAroundDiff = 1440 - minutesList.get(minutesList.size() - 1) + minutesList.get(0);
        minDifference = Math.min(minDifference, wrapAroundDiff);
        
        // Step 6: Return the minimum difference
        return minDifference;
    }
}
