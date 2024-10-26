import java.util.*;

class Solution {
    // Memoization map to store the minimum cost for a given needs state
    private Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    // Recursive function to explore all purchase combinations
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // If this state has been computed before, return the memoized result
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        // Calculate the cost if we buy items individually without any special offer
        int minCost = directPurchase(price, needs);

        // Try each special offer
        for (List<Integer> offer : special) {
            // Check if the offer can be applied (i.e., doesn't exceed the needs)
            List<Integer> newNeeds = new ArrayList<>();
            boolean valid = true;
            for (int i = 0; i < needs.size(); i++) {
                if (needs.get(i) < offer.get(i)) {
                    valid = false; // Offer can't be applied as it exceeds the needs
                    break;
                }
                newNeeds.add(needs.get(i) - offer.get(i));
            }

            // If the offer is valid, recursively compute the cost with the new needs
            if (valid) {
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + dfs(price, special, newNeeds));
            }
        }

        // Memoize the result for the current needs state
        memo.put(needs, minCost);
        return minCost;
    }

    // Helper function to calculate the direct purchase cost without any special offers
    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int totalCost = 0;
        for (int i = 0; i < price.size(); i++) {
            totalCost += price.get(i) * needs.get(i);
        }
        return totalCost;
    }
}
