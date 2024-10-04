class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize result array with -1s
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        // Loop twice through the array to simulate circular nature
        for (int i = 0; i < 2 * n; i++) {
            int currentNum = nums[i % n]; // Use modulo to handle the circular array

            // While the stack is not empty and currentNum is greater than the element at
            // stack's top index
            while (!stack.isEmpty() && nums[stack.peek()] < currentNum) {
                int index = stack.pop();
                result[index] = currentNum;
            }

            // Only push the index to the stack if we are in the first pass
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
