class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        // Modify the original array to have 1 if nums[i] % modulo == k, 0 otherwise
        List<Integer> indicator = new ArrayList<>(n);
        for (int num : nums) {
            indicator.add((num % modulo == k) ? 1 : 0);
        }
        
        // We'll use prefix sums to efficiently compute the count of indices
        // that satisfy nums[i] % modulo == k in any subarray
        Map<Integer, Long> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1L); // Initialize with 0 sum seen once
        
        long result = 0;
        int prefixSum = 0;
        
        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Update prefix sum
            prefixSum = (prefixSum + indicator.get(i)) % modulo;
            
            // Calculate the target prefix sum we're looking for
            int target = (prefixSum - k + modulo) % modulo;
            
            // Add the count of previous prefix sums that would make current subarray interesting
            result += prefixSumCount.getOrDefault(target, 0L);
            
            // Update the prefix sum count
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0L) + 1);
        }
        
        return result;
    }
}