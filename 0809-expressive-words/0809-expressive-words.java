import java.util.*;

class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isStretchy(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            // Check if characters match
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }

            // Count consecutive characters in s
            int sCount = 0;
            char sChar = s.charAt(i);
            while (i < s.length() && s.charAt(i) == sChar) {
                sCount++;
                i++;
            }

            // Count consecutive characters in word
            int wordCount = 0;
            char wordChar = word.charAt(j);
            while (j < word.length() && word.charAt(j) == wordChar) {
                wordCount++;
                j++;
            }

            // Check if the current group can be stretched
            if (sCount < wordCount || (sCount < 3 && sCount != wordCount)) {
                return false;
            }
        }

        // Ensure both strings are fully traversed
        return i == s.length() && j == word.length();
    }
}
