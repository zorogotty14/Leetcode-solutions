import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> results = new HashSet<>(); // Stores all unique OR results
        Set<Integer> current = new HashSet<>(); // Stores OR results for current subarrays

        for (int num : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(num); // Start a new subarray with the current number

            // Combine the current number with all previous OR results
            for (int prev : current) {
                next.add(num | prev);
            }

            // Update the global result set and move to the next position
            results.addAll(next);
            current = next;
        }

        return results.size();
    }
}
