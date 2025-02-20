import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        char[] choices = {'a', 'b', 'c'};
        
        // Start backtracking with an empty string
        backtrack(n, "", happyStrings, choices);
        
        // If k is out of bounds, return empty string
        return k <= happyStrings.size() ? happyStrings.get(k - 1) : "";
    }
    
    private void backtrack(int n, String current, List<String> happyStrings, char[] choices) {
        // Base case: If the string is of length n, add to list
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }
        
        // Try adding each character, ensuring it's different from the last
        for (char c : choices) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != c) {
                backtrack(n, current + c, happyStrings, choices);
            }
        }
    }
}
