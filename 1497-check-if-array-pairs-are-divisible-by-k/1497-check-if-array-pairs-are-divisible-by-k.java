class Solution {
    public boolean canArrange(int[] arr, int k) {
        // Array to store the frequency of remainders
        int[] remainderCounts = new int[k];
        
        // Fill the remainderCounts array
        for (int num : arr) {
            int remainder = num % k;
            // Handle negative remainders
            if (remainder < 0) remainder += k;
            remainderCounts[remainder]++;
        }
        
        // Check if the pairs can be formed
        for (int i = 0; i <= k / 2; i++) {
            if (i == 0) {
                // Special case: numbers which are exactly divisible by k
                if (remainderCounts[i] % 2 != 0) {
                    return false;  // Need an even count to form pairs
                }
            } else {
                // For any other remainder i, it must have the same count as remainder k - i
                if (remainderCounts[i] != remainderCounts[k - i]) {
                    return false;  // Can't form valid pairs
                }
            }
        }
        
        // If we can form all pairs, return true
        return true;
    }
}
