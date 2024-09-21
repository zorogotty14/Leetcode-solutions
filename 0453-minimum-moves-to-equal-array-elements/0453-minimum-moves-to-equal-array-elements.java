class Solution {
    public int minMoves(int[] nums) {
        // Find the minimum element in the array
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        
        // Calculate the total number of moves
        int moves = 0;
        for (int num : nums) {
            moves += num - min; // Increment count by how much each element exceeds the minimum
        }
        
        return moves;
    }
}
