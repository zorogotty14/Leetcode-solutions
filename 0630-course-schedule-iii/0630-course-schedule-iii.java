import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        // Step 1: Sort courses by their deadlines (lastDay)
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // Step 2: Use a max-heap to keep track of course durations
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int currentTime = 0;

        // Step 3: Iterate through the sorted courses
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            // Add the current course to the schedule
            currentTime += duration;
            maxHeap.offer(duration);

            // If the total time exceeds the current course's last day, drop the longest course
            if (currentTime > lastDay) {
                currentTime -= maxHeap.poll();  // Remove the longest duration course
            }
        }

        // The size of the heap gives the maximum number of courses we can take
        return maxHeap.size();
    }
}
