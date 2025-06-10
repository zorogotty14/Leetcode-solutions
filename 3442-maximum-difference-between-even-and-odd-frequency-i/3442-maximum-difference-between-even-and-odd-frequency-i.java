class Solution {
    public int maxDifference(String s) {
        // Count frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int maxOddFreq = -1;
        int minEvenFreq = Integer.MAX_VALUE;
        
        // Find max odd frequency and min even frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] % 2 == 1) { // Odd frequency
                    maxOddFreq = Math.max(maxOddFreq, freq[i]);
                } else { // Even frequency
                    minEvenFreq = Math.min(minEvenFreq, freq[i]);
                }
            }
        }
        
        return maxOddFreq - minEvenFreq;
    }
}