import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Bucket sort based on frequency
        // Create an array of lists where index represents the frequency
        List<Character>[] buckets = new List[s.length() + 1]; // Maximum frequency can't exceed s.length()
        for (int i = 0; i <= s.length(); i++) {
            buckets[i] = new ArrayList<>();
        }

        // Populate the buckets with characters based on their frequency
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char character = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].add(character);
        }

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = s.length(); i > 0; i--) { // Traverse from high frequency to low
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    result.append(c); // Append the character 'i' times
                }
            }
        }

        return result.toString();
    }
}
