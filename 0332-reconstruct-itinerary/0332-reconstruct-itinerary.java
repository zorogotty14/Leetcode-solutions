import java.util.*;

class Solution {
    private LinkedList<String> result;
    private Map<String, PriorityQueue<String>> flights;

    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        flights = new HashMap<>();
        
        // Step 1: Build the graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            flights.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }
        
        // Step 2: Perform DFS starting from "JFK"
        dfs("JFK");
        
        return result;
    }
    
    private void dfs(String airport) {
        PriorityQueue<String> destinations = flights.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport);
        }
        result.addFirst(airport);
    }
}
