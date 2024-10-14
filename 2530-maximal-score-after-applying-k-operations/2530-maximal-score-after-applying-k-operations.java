import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        // Max-heap to store the elements of nums in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all elements of nums to the heap
        for (int num : nums) {
            maxHeap.offer(num);
        }
        
        long score = 0;  // to store the total score
        
        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Extract the largest element
            int largest = maxHeap.poll();
            
            // Add it to the score
            score += largest;
            
            // Replace the element with ceil(largest / 3) and reinsert it into the heap
            maxHeap.offer((largest + 2) / 3); // ceil(largest / 3) is the same as (largest + 2) / 3
        }
        
        return score;  // Return the maximum possible score after k operations
    }
}
