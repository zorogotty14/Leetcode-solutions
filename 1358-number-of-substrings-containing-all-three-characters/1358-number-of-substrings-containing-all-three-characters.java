class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = {-1, -1, -1}; // Stores last seen index of 'a', 'b', and 'c'
        int result = 0;
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            lastSeen[currentChar - 'a'] = right; // Update last seen index
            
            // Check if all characters 'a', 'b', 'c' are present
            int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            
            if (minIndex != -1) {
                result += minIndex + 1; // Count valid substrings ending at 'right'
            }
        }
        
        return result;
    }
}
