class Solution {
    public int lengthLongestPath(String input) {
        // Split the input by newline to process each directory/file individually
        String[] parts = input.split("\n");
        
        // Array to store the cumulative length of directories at each level
        int[] pathLengthAtLevel = new int[parts.length + 1]; // level starts from 1 (index 0 is for the root)
        int maxLength = 0; // To store the maximum file path length
        
        for (String part : parts) {
            // Calculate the depth (level) of the current directory/file based on the number of tabs
            int level = part.lastIndexOf("\t") + 1; // The level is the number of tabs ('\t')
            
            // Remove all leading tabs to get the actual name of the file/directory
            String name = part.substring(level);
            
            if (name.contains(".")) {
                // If it's a file, compute the full path length
                int length = pathLengthAtLevel[level] + name.length();
                maxLength = Math.max(maxLength, length);
            } else {
                // If it's a directory, update the cumulative length at this level
                // +1 for the '/' that will be added between directory names
                pathLengthAtLevel[level + 1] = pathLengthAtLevel[level] + name.length() + 1;
            }
        }
        
        return maxLength;
    }
}
