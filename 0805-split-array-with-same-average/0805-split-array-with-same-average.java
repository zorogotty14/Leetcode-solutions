import java.util.*;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Early pruning
        Arrays.sort(nums);
        for (int len = 1; len <= n / 2; len++) {
            if ((totalSum * len) % n == 0) {
                int target = (totalSum * len) / n;
                if (canFindSubset(nums, len, target)) return true;
            }
        }
        return false;
    }

    private boolean canFindSubset(int[] nums, int len, int target) {
        return findSubsets(nums, 0, len, target);
    }

    private boolean findSubsets(int[] nums, int start, int count, int target) {
        if (count == 0) return target == 0;
        if (start == nums.length || nums[start] > target / count) return false;

        // Include the current number
        if (findSubsets(nums, start + 1, count - 1, target - nums[start])) return true;

        // Exclude the current number
        return findSubsets(nums, start + 1, count, target);
    }
}
