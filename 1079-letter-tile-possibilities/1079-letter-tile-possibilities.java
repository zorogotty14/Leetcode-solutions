import java.util.*;

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];  // Since tiles consist of uppercase letters (A-Z)
        
        // Count the frequency of each letter in tiles
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        
        return backtrack(freq);
    }

    private int backtrack(int[] freq) {
        int count = 0;
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {  // If the letter is available
                count++;  // Count this sequence
                freq[i]--;  // Use this letter
                
                count += backtrack(freq);  // Recurse for the remaining letters
                
                freq[i]++;  // Backtrack (restore the letter count)
            }
        }
        
        return count;
    }
}
