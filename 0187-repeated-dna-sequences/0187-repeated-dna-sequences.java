class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String current = s.substring(i, i + 10);
            if (seen.contains(current)) {
                repeated.add(current);
            } else {
                seen.add(current);
            }
        }
        
        result.addAll(repeated);
        return result;
    }
}