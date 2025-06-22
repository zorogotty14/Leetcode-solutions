class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int numGroups = (n + k - 1) / k; // Ceiling division: equivalent to Math.ceil(n / k)
        String[] result = new String[numGroups];
        
        for (int i = 0; i < numGroups; i++) {
            int start = i * k;
            int end = Math.min(start + k, n);
            
            // Extract the substring for this group
            StringBuilder group = new StringBuilder(s.substring(start, end));
            
            // If this is the last group and it's incomplete, pad with fill characters
            while (group.length() < k) {
                group.append(fill);
            }
            
            result[i] = group.toString();
        }
        
        return result;
    }
}