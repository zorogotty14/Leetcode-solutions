class Solution {
    public int minimumDeletions(String word, int k) {
        // Count frequency of each character
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Get all non-zero frequencies
        int[] frequencies = new int[26];
        int count = 0;
        for (int f : freq) {
            if (f > 0) {
                frequencies[count++] = f;
            }
        }
        
        // Try each possible base frequency
        int minDeletions = Integer.MAX_VALUE;
        
        // Try base = 0 (delete all characters of some types)
        minDeletions = Math.min(minDeletions, calculateDeletions(frequencies, count, 0, k));
        
        // Try each existing frequency as base
        for (int i = 0; i < count; i++) {
            int base = frequencies[i];
            minDeletions = Math.min(minDeletions, calculateDeletions(frequencies, count, base, k));
        }
        
        return minDeletions;
    }
    
    private int calculateDeletions(int[] frequencies, int count, int base, int k) {
        int deletions = 0;
        
        for (int i = 0; i < count; i++) {
            int freq = frequencies[i];
            
            if (freq < base) {
                // Delete all characters of this type
                deletions += freq;
            } else if (freq > base + k) {
                // Keep only base + k characters, delete the rest
                deletions += freq - (base + k);
            }
            // If base <= freq <= base + k, keep all characters (no deletions needed)
        }
        
        return deletions;
    }
}