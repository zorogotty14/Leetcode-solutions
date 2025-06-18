class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        
        // Sort the array to minimize differences within groups
        Arrays.sort(nums);
        
        // Result array to store groups of 3
        int[][] result = new int[n / 3][3];
        
        // Try to form groups of 3 consecutive elements
        for (int i = 0; i < n; i += 3) {
            // Check if the difference between max and min in this group is <= k
            if (nums[i + 2] - nums[i] > k) {
                // If condition is violated, return empty array
                return new int[0][0];
            }
            
            // Add this valid group to result
            result[i / 3][0] = nums[i];
            result[i / 3][1] = nums[i + 1];
            result[i / 3][2] = nums[i + 2];
        }
        
        return result;
    }
}