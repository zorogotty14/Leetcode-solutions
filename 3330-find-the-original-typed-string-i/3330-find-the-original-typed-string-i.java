class Solution {
    public int possibleStringCount(String word) {
        int count = 1; // At least the original string is always possible
        
        int i = 0;
        while (i < word.length()) {
            int j = i;
            // Find the end of current group of identical characters
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            
            int groupLength = j - i;
            // If group has more than 1 character, Alice could have intended
            // any number from 1 to groupLength characters
            if (groupLength > 1) {
                count += groupLength - 1;
            }
            
            i = j;
        }
        
        return count;
    }
}