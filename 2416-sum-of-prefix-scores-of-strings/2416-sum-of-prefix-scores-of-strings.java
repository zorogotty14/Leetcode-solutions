class Solution {
    
    // Class to represent each node in the Trie
    class TrieNode {
        TrieNode[] children;  // Array of 26 nodes, one for each lowercase letter
        int prefixCount;      // Number of words passing through this node
        
        TrieNode() {
            children = new TrieNode[26];  // Since the input is lowercase English letters
            prefixCount = 0;              // Initially, no words have passed through this node
        }
    }
    
    // Class to represent the Trie (Prefix Tree)
    class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();  // Initialize the root of the Trie
        }
        
        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';  // Convert character to index (0-25)
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();  // Create a new node if none exists
                }
                node = node.children[index];
                node.prefixCount++;  // Increment the prefix count as we move through the Trie
            }
        }
        
        // Get the total prefix score for a given word
        public int getPrefixScore(String word) {
            TrieNode node = root;
            int score = 0;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                node = node.children[index];
                score += node.prefixCount;  // Add the number of words that pass through this prefix
            }
            return score;
        }
    }
    
    // Main function to calculate the sum of prefix scores for each word
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int n = words.length;
        int[] result = new int[n];
        
        // Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }
        
        // For each word, calculate the sum of the scores of all its prefixes
        for (int i = 0; i < n; i++) {
            result[i] = trie.getPrefixScore(words[i]);
        }
        
        return result;  // Return the result array
    }
}
