class Solution {
    public String largestNumber(int[] nums) {
        // Convert the numbers to strings for easy comparison
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort strings using a custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is '0', just return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the largest number by concatenating the sorted strings
        StringBuilder largestNumber = new StringBuilder();
        for (String str : strNums) {
            largestNumber.append(str);
        }

        return largestNumber.toString();
    }
}