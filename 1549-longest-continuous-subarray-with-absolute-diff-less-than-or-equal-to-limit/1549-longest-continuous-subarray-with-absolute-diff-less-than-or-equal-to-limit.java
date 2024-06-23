class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int i = 0;
        int maxLength = 0;

        for (int j = 0; j < nums.length; j++) {
            // Update maxDeque to maintain the decreasing order
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[j]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(j);

            // Update minDeque to maintain the increasing order
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[j]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(j);

            // If the condition is violated, adjust the start of the window
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                i++;
                if (maxDeque.peekFirst() < i) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < i) {
                    minDeque.pollFirst();
                }
            }

            // Update the maximum length of the valid subarray
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}