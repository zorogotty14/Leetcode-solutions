import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return indices;

        int wordLength = words[0].length();
        int substringLength = wordLength * words.length;
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> seenWords = new HashMap<>();
            
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String currentWord = s.substring(j, j + wordLength);
                
                if (wordCount.containsKey(currentWord)) {
                    seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);
                    count++;
                    
                    while (seenWords.get(currentWord) > wordCount.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                    
                    if (count == words.length) {
                        indices.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = j + wordLength;
                }
            }
        }
        
        return indices;
    }
}
