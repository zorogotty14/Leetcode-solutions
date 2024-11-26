import java.util.*;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        // Step 1: Remove duplicates
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        // Step 2: Sort words by reverse order (longest suffixes first)
        List<String> sortedWords = new ArrayList<>(uniqueWords);
        Collections.sort(sortedWords, (a, b) -> Integer.compare(b.length(), a.length()));

        // Step 3: Build the Trie and calculate encoding length
        TrieNode root = new TrieNode();
        int totalLength = 0;

        for (String word : sortedWords) {
            TrieNode current = root;
            boolean isNew = false;

            // Insert the word into the Trie in reverse order
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (!current.children.containsKey(ch)) {
                    current.children.put(ch, new TrieNode());
                    isNew = true; // New characters mean it's a new word
                }
                current = current.children.get(ch);
            }

            // If the word is not a suffix, add its length to the total
            if (isNew) {
                totalLength += word.length() + 1; // +1 for the '#' character
            }
        }

        return totalLength;
    }
}

// Trie Node Class
class TrieNode {
    Map<Character, TrieNode> children;

    public TrieNode() {
        this.children = new HashMap<>();
    }
}
