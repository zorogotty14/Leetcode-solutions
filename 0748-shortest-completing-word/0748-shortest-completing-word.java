import java.util.HashMap;
import java.util.Map;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // Step 1: Build the character count map for licensePlate
        int[] targetCount = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                targetCount[Character.toLowerCase(c) - 'a']++;
            }
        }

        // Step 2: Find the shortest completing word
        String result = null;
        for (String word : words) {
            if (isCompletingWord(word, targetCount)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }

    // Helper method to check if a word completes the target counts
    private boolean isCompletingWord(String word, int[] targetCount) {
        int[] wordCount = new int[26];
        for (char c : word.toCharArray()) {
            wordCount[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (wordCount[i] < targetCount[i]) {
                return false;
            }
        }
        return true;
    }
}
