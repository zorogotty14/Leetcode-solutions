class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n);
        return result;
    }
    private static void backtrack(List<String> result, String currentString, int n) {
        if (currentString.length() == n) {
            result.add(currentString);
            return;
        }
        
        if (currentString.isEmpty() || currentString.charAt(currentString.length() - 1) != '0') {
            backtrack(result, currentString + '0', n);
        }
        
        backtrack(result, currentString + '1', n);
    }
}