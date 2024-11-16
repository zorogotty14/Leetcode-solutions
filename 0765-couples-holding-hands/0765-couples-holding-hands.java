class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] position = new int[n]; // Maps person to their current index in the row
        
        // Initialize the position array
        for (int i = 0; i < n; i++) {
            position[row[i]] = i;
        }

        int swaps = 0;
        
        // Iterate over the row, checking couples at every pair of seats (i, i + 1)
        for (int i = 0; i < n; i += 2) {
            int firstPerson = row[i];
            int secondPerson = firstPerson ^ 1; // Finds the expected partner (0 <-> 1, 2 <-> 3, etc.)
            
            // If the current pair is not a couple
            if (row[i + 1] != secondPerson) {
                swaps++;
                
                // Get the current position of the partner
                int partnerIndex = position[secondPerson];
                
                // Swap the partner into the correct position
                swap(row, position, i + 1, partnerIndex);
            }
        }

        return swaps;
    }

    // Helper method to swap elements in the row and update their positions
    private void swap(int[] row, int[] position, int i, int j) {
        // Swap in the row array
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
        
        // Update the position mapping
        position[row[i]] = i;
        position[row[j]] = j;
    }
}
