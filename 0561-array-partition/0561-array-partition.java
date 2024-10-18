import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        int sum = 0;

        // Step 2: Sum every alternate element (starting from index 0)
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];  // Add the smaller number in each adjacent pair
        }

        return sum;
    }
}
