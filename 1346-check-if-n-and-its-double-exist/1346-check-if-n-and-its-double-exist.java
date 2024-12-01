import java.util.HashSet;

class Solution {
    public boolean checkIfExist(int[] arr) {
        // Create a set to store numbers we've seen
        HashSet<Integer> seen = new HashSet<>();

        // Iterate through the array
        for (int num : arr) {
            // Check if the double or half (if divisible) exists in the set
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            // Add the current number to the set
            seen.add(num);
        }
        // If no pair is found, return false
        return false;
    }
}
