import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String order, String s) {
        // Frequency map for characters in s
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // StringBuilder for the result
        StringBuilder result = new StringBuilder();

        // Add characters from order in the specified order
        for (char c : order.toCharArray()) {
            if (freqMap.containsKey(c)) {
                int count = freqMap.get(c);
                for (int i = 0; i < count; i++) {
                    result.append(c);
                }
                freqMap.remove(c);
            }
        }

        // Add remaining characters from s that are not in order
        for (char c : freqMap.keySet()) {
            int count = freqMap.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
