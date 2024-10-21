import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            // If we reach the end of the string, return 0 as no more splits are possible
            return 0;
        }

        int maxSplits = 0;

        // Try all possible substrings starting from the current index
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);

            // Check if the substring is unique (not already used)
            if (!seen.contains(substring)) {
                seen.add(substring); // Add it to the set

                // Recursively explore further splits and update maxSplits
                int splits = 1 + backtrack(s, i, seen);

                maxSplits = Math.max(maxSplits, splits);

                seen.remove(substring); // Backtrack (remove from the set)
            }
        }

        return maxSplits;
    }
}
