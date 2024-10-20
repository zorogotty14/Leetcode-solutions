class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n]; // To track visited elements
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int length = 0;
                int current = i;

                // Traverse the cycle starting from index i
                while (!visited[current]) {
                    visited[current] = true; // Mark the element as visited
                    current = nums[current]; // Move to the next element in the cycle
                    length++; // Increment the length of the current cycle
                }

                // Update the maximum length of any cycle found so far
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength; // Return the longest cycle length
    }
}
