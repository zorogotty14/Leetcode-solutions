import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return result; // No possible anagrams if s is shorter than p
        }

        int[] countP = new int[26];
        int[] countS = new int[26];

        // Populate the frequency array for p
        for (int i = 0; i < pLen; i++) {
            countP[p.charAt(i) - 'a']++;
        }

        // Iterate over s with a sliding window
        for (int i = 0; i < sLen; i++) {
            // Add current character to countS
            countS[s.charAt(i) - 'a']++;

            // Remove the character that is no longer in the window
            if (i >= pLen) {
                countS[s.charAt(i - pLen) - 'a']--;
            }

            // Compare the frequency arrays
            if (i >= pLen - 1) {
                if (matches(countP, countS)) {
                    // Add the starting index of the anagram
                    result.add(i - pLen + 1);
                }
            }
        }

        return result;
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] countP, int[] countS) {
        for (int i = 0; i < 26; i++) {
            if (countP[i] != countS[i]) {
                return false;
            }
        }
        return true;
    }
}
