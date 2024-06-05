class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        
        int j = 1;
        
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[j] || nums[i] != nums[j - 1]) {
                nums[++j] = nums[i];
            }
        }
    
        return j + 1;
    }
}