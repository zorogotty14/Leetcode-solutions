class Solution {
    public int minSwaps(String s) {
        int imbalance = 0;  // Tracks unmatched closing brackets ']'
        int maxImbalance = 0;  // Tracks the maximum imbalance encountered

        for (char c : s.toCharArray()) {
            if (c == '[') {
                // A matching opening bracket reduces the imbalance
                if (imbalance > 0) {
                    imbalance--;
                }
            } else {  // c == ']'
                // Increase imbalance for each unmatched closing bracket
                imbalance++;
                // Track the maximum imbalance
                maxImbalance = Math.max(maxImbalance, imbalance);
            }
        }

        // Minimum swaps is half the maximum imbalance, as each swap fixes two brackets
        return (maxImbalance + 1) / 2;
    }
}
