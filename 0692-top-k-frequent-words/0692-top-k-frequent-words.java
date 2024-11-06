import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Count the frequency of each word
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Use a priority queue (min-heap) with custom comparator
        PriorityQueue<String> minHeap = new PriorityQueue<>((w1, w2) -> {
            int freq1 = wordCount.get(w1);
            int freq2 = wordCount.get(w2);
            if (freq1 == freq2) {
                return w2.compareTo(w1); // If frequencies are the same, use lexicographical order (reverse)
            }
            return Integer.compare(freq1, freq2); // Otherwise, compare by frequency
        });

        // Add words to the heap and maintain the size of the heap to k
        for (String word : wordCount.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Extract elements from the heap into a result list in reverse order
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result); // Reverse to get the correct order

        return result;
    }
}
