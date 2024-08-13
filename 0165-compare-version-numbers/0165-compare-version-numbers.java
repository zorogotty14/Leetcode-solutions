public class Solution {
    public int compareVersion(String version1, String version2) {
        // Split the version strings by '.'
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.max(v1.length, v2.length);
        
        // Compare each revision one by one
        for (int i = 0; i < len; i++) {
            int rev1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int rev2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (rev1 < rev2) {
                return -1;
            } else if (rev1 > rev2) {
                return 1;
            }
        }
        
        // If all revisions are the same, return 0
        return 0;
    }
}
