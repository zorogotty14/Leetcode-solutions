import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isPossible(int[] nums) {
        // HashMap to store the frequency of each number in the array
        Map<Integer, Integer> freq = new HashMap<>();
        // HashMap to store how many subsequences are waiting for a specific number
        Map<Integer, Integer> need = new HashMap<>();

        // Fill the frequency map with the counts of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Iterate through the numbers to build subsequences
        for (int num : nums) {
            // If the current number is already used in all possible subsequences, skip it
            if (freq.get(num) == 0) {
                continue;
            }

            // If there is a subsequence waiting for the current number, extend it
            if (need.getOrDefault(num, 0) > 0) {
                // Decrease the need for the current number
                need.put(num, need.get(num) - 1);
                // Increase the need for the next number in the subsequence
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            } 
            // If no subsequence is waiting for the current number, try to start a new one
            else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                // Use the current number and the next two numbers to form a new subsequence
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                // Now we need the next number in the new subsequence
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } 
            // If neither extending nor starting a new subsequence is possible, return false
            else {
                return false;
            }

            // Decrease the frequency of the current number
            freq.put(num, freq.get(num) - 1);
        }

        // If all numbers have been successfully used in valid subsequences, return true
        return true;
    }
}
