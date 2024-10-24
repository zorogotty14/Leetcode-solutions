import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);  // Sort the array
        int count = 0;
        
        // Iterate over the array, treating nums[k] as the largest side
        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0, j = k - 1;  // Two pointers
            
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // If nums[i] + nums[j] > nums[k], all elements between i and j form valid pairs
                    count += j - i;
                    j--;  // Move the right pointer leftward
                } else {
                    i++;  // Move the left pointer rightward
                }
            }
        }
        
        return count;
    }
}
