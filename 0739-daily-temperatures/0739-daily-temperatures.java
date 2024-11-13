class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // Stack to keep track of indices of temperatures
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While there is a temperature in the stack and the current temperature is higher
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index; // Calculate the number of days
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // The indices left in the stack will have answer[i] = 0 (no warmer day)
        return answer;
    }
}
