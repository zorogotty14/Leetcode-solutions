class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count the occurrences of each element in nums1
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Build the result based on the counts in nums1
        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                result.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        // Convert the result list to an array
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        return intersection;
    }
}