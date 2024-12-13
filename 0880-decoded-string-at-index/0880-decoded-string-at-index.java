class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;

        // Calculate the length of the decoded string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }

        // Traverse the string in reverse to find the kth character
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                size /= c - '0';
                k %= size;
            } else {
                if (k == 0 || k == size) {
                    return Character.toString(c);
                }
                size--;
            }
        }

        return ""; // This line should never be reached
    }
}