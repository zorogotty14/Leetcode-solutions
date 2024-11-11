import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestWord(String[] words) {
        // Sort words to ensure lexicographical order in case of ties
        Arrays.sort(words);

        Set<String> builtWords = new HashSet<>();
        String result = "";

        for (String word : words) {
            // If the word has length 1 or if its prefix is in the set
            if (word.length() == 1 || builtWords.contains(word.substring(0, word.length() - 1))) {
                builtWords.add(word);
                // Update the result if we found a longer word or a lexicographically smaller one
                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }
}
