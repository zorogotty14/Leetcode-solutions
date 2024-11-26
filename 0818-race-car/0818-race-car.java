import java.util.*;

class Solution {
    public int racecar(int target) {
        // Use a queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Initial state: position = 0, speed = 1, steps = 0
        queue.offer(new int[]{0, 1, 0});
        visited.add(0 + "," + 1);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int speed = current[1];
            int steps = current[2];

            // If we reach the target position, return the steps
            if (position == target) {
                return steps;
            }

            // Accelerate: move to the next position with doubled speed
            int newPosition = position + speed;
            int newSpeed = speed * 2;
            String accelerateState = newPosition + "," + newSpeed;
            if (!visited.contains(accelerateState) && Math.abs(newPosition) <= 2 * target) {
                queue.offer(new int[]{newPosition, newSpeed, steps + 1});
                visited.add(accelerateState);
            }

            // Reverse: change direction
            int reverseSpeed = (speed > 0) ? -1 : 1;
            String reverseState = position + "," + reverseSpeed;
            if (!visited.contains(reverseState)) {
                queue.offer(new int[]{position, reverseSpeed, steps + 1});
                visited.add(reverseState);
            }
        }

        // This should never be reached since the target is always reachable
        return -1;
    }
}
