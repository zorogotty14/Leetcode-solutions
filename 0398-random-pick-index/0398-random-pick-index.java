import java.util.Random;

class Solution {
    private int[] nums;
    private Random rand;

    // Constructor that initializes the object with the given nums array
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random(); // Random number generator
    }
    
    // Method to pick a random index where nums[index] == target
    public int pick(int target) {
        int count = 0;  // Count of how many times we've seen the target
        int result = -1;  // To store the result index
        
        // Traverse through the nums array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // Reservoir sampling: randomly select the current index with probability 1/count
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        
        return result;
    }
}
