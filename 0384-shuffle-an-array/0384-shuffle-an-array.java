import java.util.Random;

class Solution {
    private int[] original;
    private int[] array;
    private Random rand;

    // Constructor: Initializes the object with the array nums.
    public Solution(int[] nums) {
        original = nums.clone();  // Save a copy of the original array
        array = nums.clone();     // Work on another copy to shuffle
        rand = new Random();
    }
    
    // Resets the array to its original configuration and returns it.
    public int[] reset() {
        array = original.clone();  // Reset array to the original state
        return array;
    }
    
    // Returns a random shuffling of the array.
    public int[] shuffle() {
        // Apply Fisher-Yates shuffle
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);  // Generate a random index between 0 and i
            swap(i, j);                   // Swap the elements at indices i and j
        }
        return array;
    }
    
    // Helper function to swap two elements in the array
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
