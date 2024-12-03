class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0;
        int n = spaces.length;

        for (int i = 0; i < s.length(); i++) {
            // Check if the current index matches a space index
            if (spaceIndex < n && i == spaces[spaceIndex]) {
                result.append(' '); // Add a space
                spaceIndex++;      // Move to the next space index
            }
            result.append(s.charAt(i)); // Add the current character
        }

        return result.toString();
    }
}
