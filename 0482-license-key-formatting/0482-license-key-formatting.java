class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // Step 1: Remove all dashes and convert to uppercase
        s = s.replace("-", "").toUpperCase();

        // Step 2: Initialize StringBuilder to build the result
        StringBuilder result = new StringBuilder();

        // Step 3: Start from the end of the string and insert characters in groups of k
        int len = s.length();
        int firstGroupSize = len % k; // The size of the first group

        // Add the first group (if it exists)
        if (firstGroupSize > 0) {
            result.append(s.substring(0, firstGroupSize));
        }

        // Add the remaining groups
        for (int i = firstGroupSize; i < len; i += k) {
            if (result.length() > 0) {
                result.append('-');  // Add a dash before each group after the first
            }
            result.append(s.substring(i, i + k));
        }

        return result.toString();
    }
}
