import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0, currentSum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int start = 0;

        for (int end = 0; end < n; end++) {
            // Add the current element to the sum and update the count map
            currentSum += nums[end];
            countMap.put(nums[end], countMap.getOrDefault(nums[end], 0) + 1);

            // If the window size exceeds k, slide the window
            if (end - start + 1 > k) {
                // Remove the start element from the sum and count map
                currentSum -= nums[start];
                countMap.put(nums[start], countMap.get(nums[start]) - 1);
                if (countMap.get(nums[start]) == 0) {
                    countMap.remove(nums[start]);
                }
                start++;
            }

            // Check if window size is exactly k and all elements are distinct
            if (end - start + 1 == k && countMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
