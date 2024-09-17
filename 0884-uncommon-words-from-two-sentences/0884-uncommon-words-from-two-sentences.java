import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Split both sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Create a frequency map to store the count of each word
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Count the frequency of each word in both sentences
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Collect all words that appear exactly once
        List<String> uncommonWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }
        
        // Convert the list to an array and return
        return uncommonWords.toArray(new String[0]);
    }
}
