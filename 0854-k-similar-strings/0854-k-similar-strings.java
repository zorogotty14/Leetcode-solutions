import java.util.*;

class Solution {
    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s1);
        visited.add(s1);

        int swaps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // If the current string matches s2, return the number of swaps
                if (current.equals(s2)) return swaps;

                // Generate all valid next states by swapping mismatched characters
                for (String next : getNeighbors(current, s2)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            swaps++;
        }

        return -1; // This line should never be reached
    }

    private List<String> getNeighbors(String s, String target) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = s.toCharArray();

        // Find the first mismatched index
        int i = 0;
        while (i < s.length() && chars[i] == target.charAt(i)) {
            i++;
        }

        // Try swapping the first mismatched character with compatible characters
        for (int j = i + 1; j < s.length(); j++) {
            if (chars[j] == target.charAt(i) && chars[j] != target.charAt(j)) {
                swap(chars, i, j);
                neighbors.add(new String(chars));
                swap(chars, i, j); // Backtrack
            }
        }

        return neighbors;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
