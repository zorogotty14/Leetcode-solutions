import java.util.*;

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length();
        int start = 0;

        for (int i = 0; i < n; i++) {
            // Check if the current group ends
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                // Calculate the size of the group
                int groupSize = i - start + 1;
                if (groupSize >= 3) {
                    result.add(Arrays.asList(start, i));
                }
                // Update the start for the next group
                start = i + 1;
            }
        }

        return result;
    }
}
