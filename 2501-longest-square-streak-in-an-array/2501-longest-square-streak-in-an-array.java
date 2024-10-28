import java.util.*;

class Solution {
    public int longestSquareStreak(int[] nums) {
        // Use a map to store the longest streak ending at each number
        Map<Integer, Integer> mp = new HashMap<>();
        Arrays.sort(nums);
        int res = -1;

        // Iterate through the sorted array
        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);

            // Check if the current number is a perfect square of a previous number
            if (sqrt * sqrt == num && mp.containsKey(sqrt)) {
                mp.put(num, mp.get(sqrt) + 1); // Extend the streak
                res = Math.max(res, mp.get(num)); // Update the result
            } else {
                mp.put(num, 1); // Start a new streak
            }
        }

        // If no valid streak of length >= 2 is found, return -1
        return res >= 2 ? res : -1;
    }
}
