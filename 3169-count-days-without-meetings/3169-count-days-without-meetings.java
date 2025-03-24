class Solution {
    public int countDays(int days, int[][] meetings) {
        // Create a TreeMap to store the start and end points of meetings
        TreeMap<Integer, Integer> timeline = new TreeMap<>();
        
        // Process each meeting
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            
            // For each start day, increase the count of ongoing meetings
            timeline.put(start, timeline.getOrDefault(start, 0) + 1);
            // For each end day + 1, decrease the count of ongoing meetings
            timeline.put(end + 1, timeline.getOrDefault(end + 1, 0) - 1);
        }
        
        int totalMeetingDays = 0;
        int ongoingMeetings = 0;
        int prevDay = 1;
        
        // Process the timeline events in order
        for (Map.Entry<Integer, Integer> event : timeline.entrySet()) {
            int currentDay = event.getKey();
            
            // If there are ongoing meetings, count the days between previous event and current event
            if (ongoingMeetings > 0) {
                totalMeetingDays += Math.min(currentDay - prevDay, days - prevDay + 1);
            }
            
            // Update the count of ongoing meetings
            ongoingMeetings += event.getValue();
            prevDay = currentDay;
            
            // If we've processed all days, we can stop
            if (prevDay > days) {
                break;
            }
        }
        
        // Return the number of days without meetings
        return days - totalMeetingDays;
    }
}