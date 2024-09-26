import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Find the median
        int median = nums[nums.length / 2];
        
        // Step 3: Calculate the total number of moves to make all elements equal to the median
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }
}
