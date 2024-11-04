class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0;
        int n = word.length();
        
        while (i < n) {
            char c = word.charAt(i);
            int count = 0;
            
            // Count occurrences of the same character up to a max of 9
            while (i < n && word.charAt(i) == c && count < 9) {
                count++;
                i++;
            }
            
            // Append the count and character to the compressed string
            comp.append(count).append(c);
        }
        
        return comp.toString();
    }
}
