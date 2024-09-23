import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);
        
        int contentChildren = 0;
        int i = 0; // Pointer for greed factor array (children)
        int j = 0; // Pointer for cookie size array (cookies)
        
        // Iterate through both arrays
        while (i < g.length && j < s.length) {
            // If the current cookie can satisfy the current child's greed
            if (s[j] >= g[i]) {
                contentChildren++; // One more content child
                i++; // Move to the next child
            }
            // Move to the next cookie in both cases (whether the cookie was used or not)
            j++;
        }
        
        // Return the maximum number of content children
        return contentChildren;
    }
}
