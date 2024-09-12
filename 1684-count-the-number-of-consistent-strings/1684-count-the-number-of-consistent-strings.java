import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Step 1: Store the allowed characters in a set for fast lookup
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }
        
        // Step 2: Count consistent words
        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;  // No need to check further if we find an inconsistent character
                }
            }
            if (isConsistent) {
                count++;
            }
        }
        
        return count;
    }
}
