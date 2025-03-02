import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Create a TreeMap to store id and their corresponding summed values
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // Add elements from nums1 to the map
        for (int[] pair : nums1) {
            int id = pair[0];
            int value = pair[1];
            map.put(id, map.getOrDefault(id, 0) + value);
        }
        
        // Add elements from nums2 to the map, summing values if id exists
        for (int[] pair : nums2) {
            int id = pair[0];
            int value = pair[1];
            map.put(id, map.getOrDefault(id, 0) + value);
        }
        
        // Prepare the result array
        int[][] result = new int[map.size()][2];
        int index = 0;
        
        // Populate the result array from the TreeMap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }
        
        return result;
    }
}
