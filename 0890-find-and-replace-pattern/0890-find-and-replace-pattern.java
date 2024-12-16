import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        String normalizedPattern = normalize(pattern);

        for (String word : words) {
            if (normalize(word).equals(normalizedPattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private String normalize(String word) {
        Map<Character, Integer> charToIndex = new HashMap<>();
        StringBuilder normalized = new StringBuilder();
        int index = 0;

        for (char c : word.toCharArray()) {
            charToIndex.putIfAbsent(c, index++);
            normalized.append(charToIndex.get(c));
        }

        return normalized.toString();
    }
}
