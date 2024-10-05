class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) {
            return false;
        }
        
        // Frequency arrays for s1 and current window in s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];
        
        // Fill the frequency array for s1 and the first window in s2
        for (int i = 0; i < len1; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }
        
        // Check if the first window matches
        if (matches(s1Freq, windowFreq)) {
            return true;
        }
        
        // Slide the window across s2
        for (int i = len1; i < len2; i++) {
            // Add the new character to the window
            windowFreq[s2.charAt(i) - 'a']++;
            // Remove the character that is no longer in the window
            windowFreq[s2.charAt(i - len1) - 'a']--;
            
            // Check if the current window matches
            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }
        
        return false;
    }
    
    // Helper method to check if two frequency arrays are the same
    private boolean matches(int[] s1Freq, int[] windowFreq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != windowFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
