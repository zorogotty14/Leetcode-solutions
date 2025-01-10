import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26]; // To store max frequency requirements for all chars in words2

        // Step 1: Build the maxFreq array from words2
        for (String b : words2) {
            int[] freq = getCharFrequency(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        // Step 2: Check each word in words1 against maxFreq
        List<String> result = new ArrayList<>();
        for (String a : words1) {
            int[] freq = getCharFrequency(a);
            if (isUniversal(freq, maxFreq)) {
                result.add(a);
            }
        }

        return result;
    }

    // Helper function to calculate character frequencies
    private int[] getCharFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Helper function to check if word1 satisfies maxFreq requirements
    private boolean isUniversal(int[] freq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
