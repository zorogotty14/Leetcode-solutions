import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        // HashMap to store (cumulativeSum, index)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Base case: cumulative sum of 0 at index -1
        
        int maxLength = 0;
        int cumulativeSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1 for balance calculation
            cumulativeSum += (nums[i] == 0) ? -1 : 1;
            
            // Check if this cumulative sum has been seen before
            if (map.containsKey(cumulativeSum)) {
                // Calculate the length of the subarray
                int previousIndex = map.get(cumulativeSum);
                maxLength = Math.max(maxLength, i - previousIndex);
            } else {
                // Store the first occurrence of this cumulative sum
                map.put(cumulativeSum, i);
            }
        }
        
        return maxLength;
    }
}
