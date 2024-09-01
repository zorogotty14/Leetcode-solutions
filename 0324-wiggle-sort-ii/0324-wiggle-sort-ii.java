import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] temp = new int[n];
        
        // Step 2: Fill the even indices with the smaller half of the numbers
        int j = (n + 1) / 2 - 1;  // Middle of the array
        for (int i = 0; i < n; i += 2) {
            temp[i] = nums[j--];
        }
        
        // Step 3: Fill the odd indices with the larger half of the numbers
        j = n - 1;  // End of the array
        for (int i = 1; i < n; i += 2) {
            temp[i] = nums[j--];
        }
        
        // Copy the result back to nums
        System.arraycopy(temp, 0, nums, 0, n);
    }
}
