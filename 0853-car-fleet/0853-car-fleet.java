import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Create an array of cars with their positions and times to reach the target
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort cars by their starting positions in descending order
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double lastTime = 0;

        // Iterate through the sorted cars
        for (int i = 0; i < n; i++) {
            double currentTime = cars[i][1];
            // If the current car's time is greater than the last recorded time,
            // it forms a new fleet
            if (currentTime > lastTime) {
                fleets++;
                lastTime = currentTime;
            }
        }

        return fleets;
    }
}
