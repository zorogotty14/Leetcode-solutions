import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Sort the weights of the people
        Arrays.sort(people);
        
        int left = 0; // Pointer to the lightest person
        int right = people.length - 1; // Pointer to the heaviest person
        int boats = 0;

        while (left <= right) {
            // Check if the lightest and heaviest person can share a boat
            if (people[left] + people[right] <= limit) {
                left++; // Include the lightest person
            }
            // Always include the heaviest person
            right--;
            boats++; // Increment the boat count
        }

        return boats;
    }
}
