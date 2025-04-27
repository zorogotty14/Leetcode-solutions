class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        
        // Iterate through all possible starting indices of subarrays with length 3
        for (int i = 0; i <= nums.length - 3; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            
            // Check if the sum of first and third equals half of the second
            if (first + third == (double)second / 2) {
                count++;
            }
        }
        
        return count;
    }
}