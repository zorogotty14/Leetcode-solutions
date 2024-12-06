import java.util.HashSet;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Step 1: Add banned numbers to a HashSet for quick lookup
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }
        
        int currentSum = 0; // To keep track of the current sum
        int count = 0;      // To count the number of integers chosen
        
        // Step 2: Iterate through numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Skip if the number is in the banned list
            if (bannedSet.contains(i)) {
                continue;
            }
            
            // Check if adding this number exceeds maxSum
            if (currentSum + i > maxSum) {
                break;
            }
            
            // Add the number to the sum and increase the count
            currentSum += i;
            count++;
        }
        
        return count;
    }
}
