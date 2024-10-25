import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Step 1: Sort the folders lexicographically
        Arrays.sort(folder);
        
        List<String> result = new ArrayList<>();
        
        // Step 2: Track the last added folder to compare with subsequent ones
        String prev = null;

        for (String f : folder) {
            // Step 3: Check if the current folder is a sub-folder of the previous one
            if (prev == null || !f.startsWith(prev + "/")) {
                result.add(f);  // Add the current folder to the result
                prev = f;        // Update the last added folder
            }
        }
        return result;
    }
}
