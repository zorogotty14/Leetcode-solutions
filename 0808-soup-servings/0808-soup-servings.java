import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        // Optimization for large n
        if (n > 4800) return 1.0;

        return helper(n, n);
    }

    private double helper(int a, int b) {
        // Base cases
        if (a <= 0 && b <= 0) return 0.5; // Both are empty
        if (a <= 0) return 1.0;           // A is empty first
        if (b <= 0) return 0.0;           // B is empty first

        // Memoization key
        String key = a + "," + b;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recursive case
        double probability = 0.25 * (
            helper(a - 100, b) +
            helper(a - 75, b - 25) +
            helper(a - 50, b - 50) +
            helper(a - 25, b - 75)
        );

        memo.put(key, probability);
        return probability;
    }
}
