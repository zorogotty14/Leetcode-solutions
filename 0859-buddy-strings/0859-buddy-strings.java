class Solution {
    public boolean buddyStrings(String s, String goal) {
        // If lengths are not equal, it's impossible to make them equal with one swap
        if (s.length() != goal.length()) {
            return false;
        }
        
        // If the strings are already the same, check for duplicate characters
        if (s.equals(goal)) {
            // If there are duplicate characters, we can swap them
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
                if (count[c - 'a'] > 1) {
                    return true;
                }
            }
            // No duplicates, swapping won't change the string
            return false;
        }
        
        // Find indices where characters differ
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    // More than two differences, not possible with one swap
                    return false;
                }
            }
        }
        
        // Check if the swap makes the strings equal
        return second != -1 && 
               s.charAt(first) == goal.charAt(second) && 
               s.charAt(second) == goal.charAt(first);
    }
}
