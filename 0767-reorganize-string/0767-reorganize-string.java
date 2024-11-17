import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String reorganizeString(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Add characters to the max-heap based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(charCount.entrySet());
        
        // Step 3: Reorganize the string
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {
            // Extract the two most frequent characters
            Map.Entry<Character, Integer> entry1 = maxHeap.poll();
            Map.Entry<Character, Integer> entry2 = maxHeap.poll();
            
            // Append them to the result
            result.append(entry1.getKey());
            result.append(entry2.getKey());
            
            // Decrease their frequencies and add them back to the heap if still remaining
            if (entry1.getValue() > 1) {
                entry1.setValue(entry1.getValue() - 1);
                maxHeap.offer(entry1);
            }
            if (entry2.getValue() > 1) {
                entry2.setValue(entry2.getValue() - 1);
                maxHeap.offer(entry2);
            }
        }
        
        // If there is one character left
        if (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> lastEntry = maxHeap.poll();
            if (lastEntry.getValue() > 1) {
                return ""; // Not possible to rearrange
            }
            result.append(lastEntry.getKey());
        }
        
        return result.toString();
    }
}
