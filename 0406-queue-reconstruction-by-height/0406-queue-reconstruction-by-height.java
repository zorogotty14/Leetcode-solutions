import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Step 1: Sort people
        // Sort by height in descending order. If two people have the same height, sort by the number of people in front in ascending order.
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // If heights are the same, sort by k value (ascending)
            } else {
                return b[0] - a[0]; // Otherwise, sort by height (descending)
            }
        });

        // Step 2: Insert into the list
        List<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            queue.add(person[1], person);  // Insert the person at index k
        }

        // Step 3: Convert list back to array and return the result
        return queue.toArray(new int[queue.size()][]);
    }
}
