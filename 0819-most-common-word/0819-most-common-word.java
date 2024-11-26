import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Step 1: Normalize the paragraph (lowercase and remove punctuation)
        String normalizedParagraph = paragraph.toLowerCase().replaceAll("[!?',;\\.]", " ");

        // Step 2: Split the paragraph into words
        String[] words = normalizedParagraph.split("\\s+");

        // Step 3: Create a set of banned words
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // Step 4: Count the frequency of non-banned words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Step 5: Find the most frequent word
        String mostCommonWord = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommonWord;
    }
}
