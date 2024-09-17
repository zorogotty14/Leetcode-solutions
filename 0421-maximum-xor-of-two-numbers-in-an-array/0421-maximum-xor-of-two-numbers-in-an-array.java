class Solution {
    // Define TrieNode
    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; // 0 or 1
    }
    
    // Insert number into the Trie in binary form
    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        // Insert each bit of the number (starting from the 31st bit for a 32-bit integer)
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1; // Extract the ith bit
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }
    
    // Find the maximum XOR for a given number using the Trie
    private int findMaxXOR(TrieNode root, int num) {
        TrieNode node = root;
        int maxXOR = 0;
        
        // Traverse the Trie to maximize the XOR
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1; // Extract the ith bit
            // We want to take the opposite bit if possible to maximize the XOR
            int oppositeBit = 1 - bit;
            if (node.children[oppositeBit] != null) {
                maxXOR |= (1 << i); // Set the ith bit in the result
                node = node.children[oppositeBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXOR;
    }
    
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        
        // Insert all numbers into the Trie
        for (int num : nums) {
            insert(root, num);
        }
        
        // Now, find the maximum XOR by comparing each number
        int maxResult = 0;
        for (int num : nums) {
            maxResult = Math.max(maxResult, findMaxXOR(root, num));
        }
        
        return maxResult;
    }
}
