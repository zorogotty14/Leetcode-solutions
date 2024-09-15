import java.util.HashMap;

class Solution {
    public int findTheLongestSubstring(String s) {
        // Map to store the first occurrence of each bitmask state
        HashMap<Integer, Integer> stateIndexMap = new HashMap<>();
        // Initial state where no vowels have been seen (00000 -> all vowels appear an even number of times)
        stateIndexMap.put(0, -1);  // Key is bitmask, value is index
        
        int state = 0; // Bitmask to represent the parity of the vowels
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Update the bitmask based on the current character
            if (ch == 'a') {
                state ^= (1 << 0);  // Toggle the bit for 'a'
            } else if (ch == 'e') {
                state ^= (1 << 1);  // Toggle the bit for 'e'
            } else if (ch == 'i') {
                state ^= (1 << 2);  // Toggle the bit for 'i'
            } else if (ch == 'o') {
                state ^= (1 << 3);  // Toggle the bit for 'o'
            } else if (ch == 'u') {
                state ^= (1 << 4);  // Toggle the bit for 'u'
            }
            
            // If this state has been seen before, calculate the length of the substring
            if (stateIndexMap.containsKey(state)) {
                int prevIndex = stateIndexMap.get(state);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Store the first occurrence of this state
                stateIndexMap.put(state, i);
            }
        }
        
        return maxLength;
    }
}
