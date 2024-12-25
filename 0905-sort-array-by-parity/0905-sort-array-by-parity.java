class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        while (i < j) {
            // Move i forward while nums[i] is even
            while (i < j && nums[i] % 2 == 0) {
                i++;
            }
            // Move j backward while nums[j] is odd
            while (i < j && nums[j] % 2 == 1) {
                j--;
            }
            // If i < j, swap
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        
        return nums;
    }
}
