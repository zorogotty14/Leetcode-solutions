import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        // Map to store content as the key and list of file paths as the value
        Map<String, List<String>> contentToPaths = new HashMap<>();

        // Process each path string in the input
        for (String path : paths) {
            String[] parts = path.split(" ");  // Split by spaces
            String directory = parts[0];  // The first part is the directory path

            // Iterate over the rest of the parts to extract file names and content
            for (int i = 1; i < parts.length; i++) {
                // Split the file name and content by finding the '(' character
                int idx = parts[i].indexOf('(');
                String fileName = parts[i].substring(0, idx);  // Extract file name
                String content = parts[i].substring(idx + 1, parts[i].length() - 1);  // Extract content

                // Create the full path of the file
                String fullPath = directory + "/" + fileName;

                // Add the full path to the list of paths for the given content
                contentToPaths
                    .computeIfAbsent(content, k -> new ArrayList<>())
                    .add(fullPath);
            }
        }

        // Collect all the lists of duplicate file paths (i.e., lists with more than one file)
        List<List<String>> result = new ArrayList<>();
        for (List<String> pathsList : contentToPaths.values()) {
            if (pathsList.size() > 1) {
                result.add(pathsList);
            }
        }

        return result;
    }
}
