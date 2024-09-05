import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Step 1: Convert nums1 and nums2 to sets to remove duplicates
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Step 2: Iterate over nums2 and collect only the common elements
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        // Step 3: Convert the set to an array
        int[] result = new int[intersectionSet.size()];
        int i = 0;
        for (int num : intersectionSet) {
            result[i++] = num;
        }

        return result;
    }
}
