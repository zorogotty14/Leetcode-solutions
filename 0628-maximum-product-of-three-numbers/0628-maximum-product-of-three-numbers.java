import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Step 2: Calculate the two possible products
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];  // Three largest numbers
        int product2 = nums[0] * nums[1] * nums[n - 1];  // Two smallest and largest number

        // Step 3: Return the maximum of the two products
        return Math.max(product1, product2);
    }
}
