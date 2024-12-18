import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        // If k == 1, we can only rotate the string
        if (k == 1) {
            String smallest = s;
            int n = s.length();
            // Try all rotations of the string and find the smallest
            for (int i = 1; i < n; i++) {
                String rotated = s.substring(i) + s.substring(0, i);
                if (rotated.compareTo(smallest) < 0) {
                    smallest = rotated;
                }
            }
            return smallest;
        } else {
            // If k > 1, we can freely sort the string
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }
    }
}
