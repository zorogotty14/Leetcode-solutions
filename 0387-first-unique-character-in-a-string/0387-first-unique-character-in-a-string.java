class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Count the frequency of each character
        int[] freq = new int[26]; // Array to store the frequency of each character (for 'a' to 'z')
        
        // Traverse the string and count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        
        // Step 2: Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch - 'a'] == 1) {
                return i; // Return the index of the first unique character
            }
        }
        
        // If no unique character is found, return -1
        return -1;
    }
}
