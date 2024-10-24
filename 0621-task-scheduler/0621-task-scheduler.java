import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        // Step 2: Find the maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }
        
        // Step 3: Count how many tasks have the maximum frequency
        int maxFreqCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxFreqCount++;
            }
        }
        
        // Step 4: Calculate the minimum intervals required
        int partCount = maxFreq - 1; // Number of full parts
        int partLength = n + 1; // Each part can have n idle slots + 1 task
        int emptySlots = partCount * (partLength - maxFreqCount); // Remaining idle slots
        int availableTasks = tasks.length - (maxFreq * maxFreqCount); // Tasks to fill the empty slots
        int idles = Math.max(0, emptySlots - availableTasks); // Final idle count
        
        return tasks.length + idles; // Total time = tasks + idle slots
    }
}
