import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // Create a map to store the positions of each character in s
        Map<Character, List<Integer>> charPositions = new HashMap<>();
        
        // Populate the map with the positions of each character in s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charPositions.putIfAbsent(c, new ArrayList<>());
            charPositions.get(c).add(i);
        }

        int result = 0;
        
        // Check each word
        for (String word : words) {
            int lastPos = -1;  // Initialize last matched position
            boolean isSubsequence = true;
            
            // For each character in the word, check if we can find it in s
            for (char c : word.toCharArray()) {
                if (!charPositions.containsKey(c)) {
                    isSubsequence = false;  // If char is not in s, it's not a subsequence
                    break;
                }
                
                // Get the list of positions where character c appears in s
                List<Integer> positions = charPositions.get(c);
                
                // Binary search for the smallest index greater than lastPos
                int idx = binarySearch(positions, lastPos);
                if (idx == positions.size()) {
                    isSubsequence = false;  // No valid position found, it's not a subsequence
                    break;
                }
                
                // Update lastPos to the new matched position
                lastPos = positions.get(idx);
            }
            
            // If the word is a subsequence of s, increment the result
            if (isSubsequence) {
                result++;
            }
        }

        return result;
    }

    // Binary search to find the smallest position > lastPos
    private int binarySearch(List<Integer> positions, int lastPos) {
        int low = 0, high = positions.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (positions.get(mid) > lastPos) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
