import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // Array to store the exclusive time of each function
        int[] result = new int[n];

        // Stack to track the currently running functions by their IDs
        Stack<Integer> stack = new Stack<>();

        // Track the previous timestamp to calculate the time spent
        int prevTime = 0;

        // Iterate through each log entry
        for (String log : logs) {
            // Split the log into parts: function_id, type (start/end), timestamp
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                // If a function starts, update the time of the previous function (if any)
                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - prevTime;
                }
                // Push the current function onto the stack
                stack.push(id);
                // Update the previous time to the current time
                prevTime = time;
            } else {
                // If a function ends, update its time
                result[stack.pop()] += time - prevTime + 1;
                // Update the previous time to the next timestamp after the current one
                prevTime = time + 1;
            }
        }

        return result;
    }
}
