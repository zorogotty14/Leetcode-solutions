class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, nums.length);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int first, int n) {
        if (first == n) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            result.add(current);
            return;
        }
        for (int i = first; i < n; i++) {
            swap(nums, first, i);
            backtrack(result, nums, first + 1, n);
            swap(nums, first, i); // Backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}