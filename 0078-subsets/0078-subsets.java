class Solution {
   public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }
    
    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add the current subset to the result
        
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]); // Include nums[i] in the current subset
            generateSubsets(i + 1, nums, current, result); // Recursively generate subsets with nums[i]
            current.remove(current.size() - 1); // Backtrack: remove nums[i] from the current subset
        }
    }
}