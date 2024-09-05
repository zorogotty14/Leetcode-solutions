import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort the envelopes by width, and by height in descending order when widths are the same
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Sort by height in descending order if widths are the same
            } else {
                return a[0] - b[0]; // Sort by width in ascending order
            }
        });

        // Step 2: Find the LIS based on heights
        // We will apply the LIS algorithm on the heights of the sorted envelopes
        List<Integer> lis = new ArrayList<>();

        for (int[] envelope : envelopes) {
            int height = envelope[1];
            // Binary search to find the position to replace or append
            int index = Collections.binarySearch(lis, height);
            if (index < 0) {
                index = -(index + 1); // If not found, get the correct insert position
            }

            // If index is equal to the size of the list, we add the height
            if (index == lis.size()) {
                lis.add(height);
            } else {
                lis.set(index, height); // Otherwise, we replace the element at index
            }
        }

        return lis.size(); // The size of lis gives the maximum number of envelopes we can Russian doll
    }
}
