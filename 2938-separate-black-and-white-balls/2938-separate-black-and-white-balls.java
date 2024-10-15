class Solution {
    public long minimumSteps(String s) {
        long ans = 0;  // To track the total number of swaps
        long c = 0;    // To count the number of '1's encountered

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                c++;  // Increment count of '1's
            } else {
                ans += c;  // For each '0', add the number of '1's encountered so far
            }
        }

        return ans;  // Return the total number of swaps
    }
}
