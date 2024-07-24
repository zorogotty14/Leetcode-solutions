class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArray, (a, b) -> Integer.compare(getMappedValue(a, mapping), getMappedValue(b, mapping)));
        return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
    }

    private static int getMappedValue(int num, int[] mapping) {
        StringBuilder mappedStr = new StringBuilder();
        for (char digit : String.valueOf(num).toCharArray()) {
            mappedStr.append(mapping[digit - '0']);
        }
        // Convert the mapped string to an integer, handling leading zeros
        return Integer.parseInt(mappedStr.toString());
    }
}