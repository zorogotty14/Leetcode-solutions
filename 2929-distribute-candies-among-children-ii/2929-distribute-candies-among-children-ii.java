class Solution {
    public long distributeCandies(int n, int limit) {
        // Use inclusion-exclusion principle
        // Total ways = ways with no constraints 
        //            - ways with at least 1 child > limit
        //            + ways with at least 2 children > limit
        //            - ways with all 3 children > limit
        
        long result = 0;
        
        // Ways with no constraints: distribute n candies among 3 children
        result += combinations(n + 2, 2);
        
        // Subtract: ways where at least 1 child gets > limit candies
        if (n > limit) {
            // If child 1 gets > limit, we need to distribute (n - limit - 1) among 3 children
            result -= 3 * combinations(n - limit - 1 + 2, 2);
        }
        
        // Add back: ways where at least 2 children get > limit candies
        if (n > 2 * limit + 1) {
            // If 2 children get > limit each, we distribute (n - 2*(limit+1)) among 3 children
            result += 3 * combinations(n - 2 * (limit + 1) + 2, 2);
        }
        
        // Subtract: ways where all 3 children get > limit candies
        if (n > 3 * limit + 2) {
            // If all 3 children get > limit each, we distribute (n - 3*(limit+1)) among 3 children
            result -= combinations(n - 3 * (limit + 1) + 2, 2);
        }
        
        return result;
    }
    
    // Calculate C(n, k) = n! / (k! * (n-k)!)
    // For our case, we only need C(n, 2) = n * (n-1) / 2
    private long combinations(int n, int k) {
        if (n < k || n < 0) return 0;
        if (k == 2) {
            return (long) n * (n - 1) / 2;
        }
        return 0; // We only need C(n, 2) for this problem
    }
}