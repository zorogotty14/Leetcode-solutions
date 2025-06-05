class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Union-Find data structure
        int[] parent = new int[26];
        
        // Initialize: each character is its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        
        // Process equivalency information from s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            union(parent, c1 - 'a', c2 - 'a');
        }
        
        // Build result string
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int root = find(parent, c - 'a');
            result.append((char)('a' + root));
        }
        
        return result.toString();
    }
    
    // Find with path compression - returns the root of the equivalence class
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }
    
    // Union two characters - always make the lexicographically smaller one the root
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        
        if (rootX != rootY) {
            // Union by making the smaller character the root
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }
}

// Alternative solution with more explicit equivalence class tracking
class SolutionAlternative {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Map each character to its equivalence class representative
        char[] representative = new char[26];
        
        // Initialize: each character represents itself
        for (int i = 0; i < 26; i++) {
            representative[i] = (char)('a' + i);
        }
        
        // Process equivalency pairs
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            mergeEquivalenceClasses(representative, c1, c2);
        }
        
        // Ensure all representatives are the smallest in their class
        // Multiple passes to handle transitive relationships
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < 26; i++) {
                char current = (char)('a' + i);
                char currentRep = findRepresentative(representative, current);
                if (currentRep != representative[i]) {
                    representative[i] = currentRep;
                    changed = true;
                }
            }
        }
        
        // Build result
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            result.append(findRepresentative(representative, c));
        }
        
        return result.toString();
    }
    
    private char findRepresentative(char[] representative, char c) {
        int index = c - 'a';
        if (representative[index] == c) {
            return c;
        }
        // Path compression
        representative[index] = findRepresentative(representative, representative[index]);
        return representative[index];
    }
    
    private void mergeEquivalenceClasses(char[] representative, char c1, char c2) {
        char rep1 = findRepresentative(representative, c1);
        char rep2 = findRepresentative(representative, c2);
        
        if (rep1 != rep2) {
            // Make the lexicographically smaller one the representative
            if (rep1 < rep2) {
                representative[rep2 - 'a'] = rep1;
            } else {
                representative[rep1 - 'a'] = rep2;
            }
        }
    }
}