import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // Step 1: Store list1 elements and their indices in a map
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Step 2: Traverse list2 and find common strings with the least index sum
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int i = map.get(list2[j]); // Get the index from list1
                int indexSum = i + j; // Calculate the index sum

                // If this index sum is smaller, update the minimum and reset the result list
                if (indexSum < minSum) {
                    minSum = indexSum;
                    result.clear(); // Clear previous results
                    result.add(list2[j]);
                } else if (indexSum == minSum) {
                    // If the index sum is equal to the minimum, add to the result list
                    result.add(list2[j]);
                }
            }
        }

        // Step 3: Convert the result list to an array and return
        return result.toArray(new String[0]);
    }
}
