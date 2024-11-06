import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(); // Frequency of each element
        Map<Integer, Integer> firstIndexMap = new HashMap<>(); // First occurrence of each element
        Map<Integer, Integer> lastIndexMap = new HashMap<>(); // Last occurrence of each element

        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            degree = Math.max(degree, countMap.get(num)); // Update degree

            // Record the first occurrence index
            firstIndexMap.putIfAbsent(num, i);
            // Record the last occurrence index
            lastIndexMap.put(num, i);
        }

        int minLength = nums.length;
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == degree) {
                // Calculate the length of the subarray for elements with maximum degree
                int length = lastIndexMap.get(num) - firstIndexMap.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }
}
