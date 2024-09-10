class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        
        // XOR all characters of s
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        
        // XOR all characters of t
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        
        // The result will hold the extra character in t
        return result;
    }
}
