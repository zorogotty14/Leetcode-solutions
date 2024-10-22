import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Step 2: Find the longest harmonious subsequence
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(key + 1)) {
                // Calculate the length of the harmonious subsequence
                int length = frequencyMap.get(key) + frequencyMap.get(key + 1);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
