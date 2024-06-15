class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineCounts = new int[26];
        
        // Count the frequency of each character in the magazine
        for (char c : magazine.toCharArray()) {
            magazineCounts[c - 'a']++;
        }

        // Check if the ransom note can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (magazineCounts[c - 'a'] == 0) {
                return false; // If the character is not available enough times
            }
            magazineCounts[c - 'a']--; // Use one occurrence of this character
        }

        return true;
    }
}