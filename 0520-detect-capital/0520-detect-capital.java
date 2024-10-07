class Solution {
    public boolean detectCapitalUse(String word) {
        // Case 1: All letters are uppercase
        if (word.equals(word.toUpperCase())) {
            return true;
        }
        
        // Case 2: All letters are lowercase
        if (word.equals(word.toLowerCase())) {
            return true;
        }
        
        // Case 3: Only the first letter is uppercase and the rest are lowercase
        if (Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }
        
        // If none of the above conditions are met, return false
        return false;
    }
}
