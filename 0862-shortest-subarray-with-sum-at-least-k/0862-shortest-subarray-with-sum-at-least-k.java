import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int result = n + 1; // Initialize with a large value (larger than the array length)
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i <= n; i++) {
            // Check if the current prefix sum subtracted by the oldest element in deque is >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.pollFirst());
            }
            
            // Maintain deque in increasing order of prefix sums
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            
            deque.addLast(i);
        }
        
        return result <= n ? result : -1;
    }
}
