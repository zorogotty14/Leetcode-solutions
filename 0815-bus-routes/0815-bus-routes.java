import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // If the source and target are the same, no buses are needed
        if (source == target) {
            return 0;
        }

        // Map each stop to the list of buses that pass through it
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.putIfAbsent(stop, new ArrayList<>());
                stopToBuses.get(stop).add(i);
            }
        }

        // BFS initialization
        Queue<Integer> queue = new LinkedList<>(); // Stores stops to visit
        Set<Integer> visitedStops = new HashSet<>(); // Tracks visited stops
        Set<Integer> visitedBuses = new HashSet<>(); // Tracks visited buses
        queue.offer(source);
        visitedStops.add(source);

        int busesTaken = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            busesTaken++;

            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();

                // Check all buses passing through the current stop
                for (int bus : stopToBuses.getOrDefault(currentStop, new ArrayList<>())) {
                    if (visitedBuses.contains(bus)) {
                        continue; // Skip if this bus has already been used
                    }

                    visitedBuses.add(bus);

                    // Visit all stops on this bus route
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) {
                            return busesTaken; // Target stop reached
                        }
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        // If BFS completes without finding the target
        return -1;
    }
}
