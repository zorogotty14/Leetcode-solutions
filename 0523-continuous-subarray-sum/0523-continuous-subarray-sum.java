import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Hash map to store the remainder when divided by k and the index of the first occurrence
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);  // Handle case where a subarray from the start is a multiple of k
        
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            // Compute the remainder of the running sum with k
            int remainder = runningSum % k;
            if (remainder < 0) {  // Handle negative remainder case
                remainder += k;
            }
            
            // Check if we have seen this remainder before
            if (remainderMap.containsKey(remainder)) {
                // Ensure the subarray length is at least 2
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                // Store the index of the first occurrence of this remainder
                remainderMap.put(remainder, i);
            }
        }
        
        return false;
    }
}
