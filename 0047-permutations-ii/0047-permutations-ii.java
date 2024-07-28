class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        boolean[] visited = new boolean[nums.length];
        backtrack(results, new ArrayList<>(), nums, visited);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> current, int[] nums, boolean[] visited) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                backtrack(results, current, nums, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}