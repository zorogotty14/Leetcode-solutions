class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remaining, int start) {
        if (remaining < 0) {
            return;  // If remaining becomes negative, stop exploring this path
        } else if (remaining == 0) {
            result.add(new ArrayList<>(tempList));  // Found a valid combination
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remaining - candidates[i], i);  // Not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);  // Backtrack
        }
    }
}