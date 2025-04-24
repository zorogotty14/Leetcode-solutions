class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // Count distinct elements in the original array
        Set<Integer> distinctElements = new HashSet<>();
        for (int num : nums) {
            distinctElements.add(num);
        }
        int totalDistinct = distinctElements.size();
        
        int count = 0;
        int n = nums.length;
        
        // For each possible starting position
        for (int start = 0; start < n; start++) {
            Set<Integer> currentDistinct = new HashSet<>();
            // Expand the subarray to the right
            for (int end = start; end < n; end++) {
                currentDistinct.add(nums[end]);
                // If we found all distinct elements, this subarray and any extension of it is complete
                if (currentDistinct.size() == totalDistinct) {
                    count += (n - end); // Count all subarrays from start to end, end+1, end+2, ..., n-1
                    break;
                }
            }
        }
        
        return count;
    }
}