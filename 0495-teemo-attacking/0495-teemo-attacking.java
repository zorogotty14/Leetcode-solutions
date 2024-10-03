class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0; // No attacks, no poison duration
        }
        
        int totalPoisonedTime = 0;
        
        // Iterate through the attack times, except the last one
        for (int i = 0; i < timeSeries.length - 1; i++) {
            // If the next attack happens after the current poison ends
            if (timeSeries[i + 1] >= timeSeries[i] + duration) {
                totalPoisonedTime += duration; // Full duration
            } else {
                // Otherwise, only count the time until the next attack
                totalPoisonedTime += timeSeries[i + 1] - timeSeries[i];
            }
        }
        
        // Always add the full duration for the last attack
        totalPoisonedTime += duration;
        
        return totalPoisonedTime;
    }
}
