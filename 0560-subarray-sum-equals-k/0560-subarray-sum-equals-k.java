import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store the frequency of prefix sums
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        
        // Initialize the HashMap with a prefix sum of 0 (to account for subarrays starting from the beginning)
        prefixSumCount.put(0, 1);
        
        int currentSum = 0;  // To store the running prefix sum
        int count = 0;       // To store the number of valid subarrays

        // Traverse through the array
        for (int num : nums) {
            currentSum += num;  // Update the current prefix sum
            
            // Check if (currentSum - k) exists in the HashMap
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update the frequency of the current prefix sum in the HashMap
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
