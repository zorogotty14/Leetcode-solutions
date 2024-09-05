class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        // Calculate total sum for n + m rolls
        int totalSum = mean * (n + m);
        
        // Calculate the sum of the given m rolls
        int knownSum = 0;
        for (int roll : rolls) {
            knownSum += roll;
        }
        
        // Calculate the sum that the missing rolls must add up to
        int missingSum = totalSum - knownSum;
        
        // Check if the missing sum can be distributed among n rolls
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0]; // Return empty array if it's not possible
        }
        
        // Initialize the result array for missing rolls
        int[] result = new int[n];
        // Distribute the missing sum over the n rolls
        int baseValue = missingSum / n;  // Base value for each roll
        int remainder = missingSum % n;  // Remainder to distribute
        
        // Fill in the result array
        for (int i = 0; i < n; i++) {
            result[i] = baseValue + (i < remainder ? 1 : 0);
        }
        
        return result;
    }
}
