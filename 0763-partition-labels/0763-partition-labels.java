import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        // Array to store the last index of each character in the string
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        // Iterate through the string to find partitions
        for (int i = 0; i < s.length(); i++) {
            // Update the end of the current partition
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            // If the current index reaches the end of the partition
            if (i == end) {
                // Add the size of the partition to the result
                result.add(end - start + 1);
                // Move the start to the next position
                start = i + 1;
            }
        }

        return result;
    }
}
