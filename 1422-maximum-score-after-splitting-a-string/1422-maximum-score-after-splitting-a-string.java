import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // Memoization map to store computed minimum costs
    private Map<Integer, Integer> memo = new HashMap<>();

    public int mincostTickets(int[] days, int[] costs) {
        // Start the recursion from day index 0
        return minCost(days, costs, 0);
    }

    private int minCost(int[] days, int[] costs, int i) {
        // If all days are covered, no cost is needed
        if (i >= days.length) {
            return 0;
        }

        // If already computed, return the stored value
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        // Option 1: Buy a 1-day pass
        int cost1 = costs[0] + minCost(days, costs, i + 1);

        // Option 2: Buy a 7-day pass
        // Find the first day not covered by the 7-day pass
        int j = findFirstDayNotCovered(days, i, 7);
        int cost7 = costs[1] + minCost(days, costs, j);

        // Option 3: Buy a 30-day pass
        // Find the first day not covered by the 30-day pass
        int k = findFirstDayNotCovered(days, i, 30);
        int cost30 = costs[2] + minCost(days, costs, k);

        // Choose the minimum of the three options
        int minCost = Math.min(cost1, Math.min(cost7, cost30));

        // Store in memoization map
        memo.put(i, minCost);

        return minCost;
    }

    // Helper function to find the first day index not covered by the pass
    private int findFirstDayNotCovered(int[] days, int start, int duration) {
        // The last day covered by the pass
        int lastDay = days[start] + duration - 1;

        // Binary search to find the insertion point for lastDay + 1
        int nextIndex = Arrays.binarySearch(days, start + 1, days.length, lastDay + 1);

        // If not found, binarySearch returns (-insertion point - 1)
        if (nextIndex < 0) {
            nextIndex = -nextIndex - 1;
        }

        return nextIndex;
    }
}
