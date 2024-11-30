import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // Step 1: Build the graph and track in-degree and out-degree
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            graph.putIfAbsent(start, new ArrayDeque<>());
            graph.get(start).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        // Step 2: Find the starting node
        int startNode = pairs[0][0]; // Default starting node
        for (int node : graph.keySet()) {
            int out = outDegree.getOrDefault(node, 0);
            int in = inDegree.getOrDefault(node, 0);
            if (out > in) {
                startNode = node;
                break;
            }
        }

        // Step 3: Perform Hierholzer's algorithm to find the Eulerian path
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int current = stack.peek();
            if (graph.containsKey(current) && !graph.get(current).isEmpty()) {
                stack.push(graph.get(current).poll());
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), current});
                }
            }
        }

        // Step 4: Reverse the result to get the correct order
        Collections.reverse(result);
        return result.toArray(new int[0][0]);
    }
}
