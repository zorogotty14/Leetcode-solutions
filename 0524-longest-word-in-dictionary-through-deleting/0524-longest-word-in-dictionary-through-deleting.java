import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // Sort dictionary first by length in descending order, then lexicographically in ascending order
        dictionary.sort((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length(); // Sort by length (descending)
            } else {
                return a.compareTo(b); // Sort lexicographically (ascending)
            }
        });
        
        // Check each word in the sorted dictionary
        for (String word : dictionary) {
            if (canForm(s, word)) {
                return word;
            }
        }
        
        return ""; // If no word can be formed
    }
    
    // Helper function to check if word can be formed by deleting characters from s
    private boolean canForm(String s, String word) {
        int i = 0, j = 0;
        
        // Use two pointers to check if word can be formed
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++; // Move both pointers when characters match
            }
            i++; // Always move pointer i
        }
        
        return j == word.length(); // If j reached the end of word, all characters were matched
    }
}
