import java.util.*;

class MagicDictionary {
    private List<String> dictionary;

    /** Initialize the data structure. */
    public MagicDictionary() {
        dictionary = new ArrayList<>();
    }
    
    /** Build the dictionary with the given list of words. */
    public void buildDict(String[] dictionary) {
        this.dictionary.addAll(Arrays.asList(dictionary));
    }
    
    /** Returns true if there exists a word in the dictionary that differs by exactly one character. */
    public boolean search(String searchWord) {
        for (String word : dictionary) {
            // Check if the word has the same length
            if (word.length() == searchWord.length()) {
                if (differsByOneChar(word, searchWord)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /** Helper method to check if two words differ by exactly one character. */
    private boolean differsByOneChar(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }
}
