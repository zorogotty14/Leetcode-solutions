import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Map to store allowed patterns in the form of base pair -> list of possible tops
        Map<String, List<Character>> patternMap = new HashMap<>();
        for (String pattern : allowed) {
            String base = pattern.substring(0, 2);
            char top = pattern.charAt(2);
            patternMap.computeIfAbsent(base, k -> new ArrayList<>()).add(top);
        }
        return dfs(bottom, "", 0, patternMap);
    }

    private boolean dfs(String currentRow, String nextRow, int index, Map<String, List<Character>> patternMap) {
        // If we've reached the top of the pyramid (single block), return true
        if (currentRow.length() == 1) {
            return true;
        }

        // If we have formed the next row completely, go to the next level
        if (index == currentRow.length() - 1) {
            return dfs(nextRow, "", 0, patternMap);
        }

        // Get the base pair from the current row
        String base = currentRow.substring(index, index + 2);
        if (!patternMap.containsKey(base)) {
            return false; // If no pattern matches, return false
        }

        // Try all possible tops for the base pair
        for (char top : patternMap.get(base)) {
            if (dfs(currentRow, nextRow + top, index + 1, patternMap)) {
                return true;
            }
        }

        return false; // If no solution is found, return false
    }
}
