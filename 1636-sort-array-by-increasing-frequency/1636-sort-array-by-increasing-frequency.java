class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Sort the array based on the custom comparator
        Integer[] sortedNums = Arrays.stream(nums)
                                     .boxed()
                                     .toArray(Integer[]::new);
        Arrays.sort(sortedNums, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB); // Sort by frequency in ascending order
            } else {
                return Integer.compare(b, a); // Sort by value in descending order
            }
        });

        // Convert the sorted array back to int[]
        return Arrays.stream(sortedNums)
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}