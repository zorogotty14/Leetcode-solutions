class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        
        // Use sliding window approach
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long currentPairs = 0;
        
        for (int right = 0; right < n; right++) {
            // Add the new element to our frequency map
            int newFreq = freq.getOrDefault(nums[right], 0) + 1;
            freq.put(nums[right], newFreq);
            
            // Update the current pairs count
            // When we add a new occurrence, we add (newFreq - 1) new pairs
            currentPairs += (newFreq - 1);
            
            // Shrink window from left until we go below k pairs
            while (left <= right && currentPairs >= k) {
                // Every valid window [left, right] creates valid subarrays ending at positions
                // right, right+1, right+2, ..., n-1
                result += (n - right);
                
                // Remove the leftmost element
                int oldFreq = freq.get(nums[left]);
                freq.put(nums[left], oldFreq - 1);
                
                // Update the current pairs count
                // When we remove an occurrence, we remove (oldFreq - 1) pairs
                currentPairs -= (oldFreq - 1);
                
                left++;
            }
        }
        
        return result;
    }
}