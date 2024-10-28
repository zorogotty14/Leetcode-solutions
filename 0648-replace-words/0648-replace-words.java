import java.util.*;

class Solution {
    // Trie Node class
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // Store the root word if a complete root ends at this node
    }

    // Insert all roots into the Trie
    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        current.word = word; // Mark the end of a root word
    }

    // Search for the shortest root for a given word
    private String searchRoot(TrieNode root, String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.children.containsKey(ch)) {
                current = current.children.get(ch);
                if (current.word != null) {
                    // Return the first root word found
                    return current.word;
                }
            } else {
                break; // No matching root prefix
            }
        }
        return word; // No root found, return original word
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        // Create a Trie and insert all roots
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            insert(root, word);
        }

        // Process the sentence word by word
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(searchRoot(root, word));
        }

        return result.toString();
    }
}
