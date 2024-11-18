import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int totalRabbits = 0;

        for (int answer : answers) {
            // Count occurrences of each answer
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        for (int key : countMap.keySet()) {
            int groupSize = key + 1;
            int numRabbits = countMap.get(key);
            // Calculate the minimum number of groups needed for rabbits answering `key`
            int groups = (numRabbits + groupSize - 1) / groupSize; // Ceiling division
            totalRabbits += groups * groupSize;
        }

        return totalRabbits;
    }
}
