import java.util.*;

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> invalid = new HashSet<>();
        int n = fronts.length;

        // Step 1: Collect invalid numbers (numbers that appear on both front and back of the same card)
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                invalid.add(fronts[i]);
            }
        }

        // Step 2: Find the minimum good integer
        int minGood = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!invalid.contains(fronts[i])) {
                minGood = Math.min(minGood, fronts[i]);
            }
            if (!invalid.contains(backs[i])) {
                minGood = Math.min(minGood, backs[i]);
            }
        }

        // Step 3: Return the result
        return minGood == Integer.MAX_VALUE ? 0 : minGood;
    }
}
