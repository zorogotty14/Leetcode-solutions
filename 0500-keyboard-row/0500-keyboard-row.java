import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String[] findWords(String[] words) {
        // Define the keyboard rows as sets for quick lookup
        Set<Character> row1 = new HashSet<>();
        Set<Character> row2 = new HashSet<>();
        Set<Character> row3 = new HashSet<>();
        
        // Fill the sets with characters corresponding to each row
        for (char c : "qwertyuiop".toCharArray()) row1.add(c);
        for (char c : "asdfghjkl".toCharArray()) row2.add(c);
        for (char c : "zxcvbnm".toCharArray()) row3.add(c);
        
        // List to store valid words
        List<String> result = new ArrayList<>();
        
        // Check each word
        for (String word : words) {
            // Convert the word to lowercase for uniform comparison
            String lowerWord = word.toLowerCase();
            if (canBeTypedWithOneRow(lowerWord, row1) || canBeTypedWithOneRow(lowerWord, row2) || canBeTypedWithOneRow(lowerWord, row3)) {
                result.add(word); // Add the original word (case preserved) if it meets the condition
            }
        }
        
        // Convert the result list to a string array
        return result.toArray(new String[0]);
    }

    // Helper method to check if all characters in the word belong to the same row
    private boolean canBeTypedWithOneRow(String word, Set<Character> row) {
        for (char c : word.toCharArray()) {
            if (!row.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
