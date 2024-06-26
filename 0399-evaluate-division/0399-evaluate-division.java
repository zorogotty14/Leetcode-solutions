class Solution {
    class Node {
        String variable;
        double value;
        Node(String variable, double value) {
            this.variable = variable;
            this.value = value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];
            
            graph.putIfAbsent(A, new ArrayList<>());
            graph.putIfAbsent(B, new ArrayList<>());
            graph.get(A).add(new Node(B, value));
            graph.get(B).add(new Node(A, 1.0 / value));
        }
        
        // Process each query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);
            if (!graph.containsKey(C) || !graph.containsKey(D)) {
                results[i] = -1.0;
            } else if (C.equals(D)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, C, D, 1.0, visited);
            }
        }
        
        return results;
    }

    private double dfs(Map<String, List<Node>> graph, String start, String end, double product, Set<String> visited) {
        if (start.equals(end)) {
            return product;
        }
        visited.add(start);
        for (Node neighbor : graph.get(start)) {
            if (!visited.contains(neighbor.variable)) {
                double result = dfs(graph, neighbor.variable, end, product * neighbor.value, visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        visited.remove(start);
        return -1.0;
    }
}