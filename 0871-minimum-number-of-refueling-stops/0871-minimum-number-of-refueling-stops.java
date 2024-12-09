import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max-heap to store available fuel from passed stations
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int currentFuel = startFuel;
        int refuels = 0;
        int stationIndex = 0;

        while (currentFuel < target) {
            // Add fuel from stations within reach
            while (stationIndex < stations.length && stations[stationIndex][0] <= currentFuel) {
                maxHeap.offer(stations[stationIndex][1]);
                stationIndex++;
            }

            // If no fuel is available in the heap, we cannot progress further
            if (maxHeap.isEmpty()) {
                return -1;
            }

            // Refuel with the largest available fuel
            currentFuel += maxHeap.poll();
            refuels++;
        }

        return refuels;
    }
}
