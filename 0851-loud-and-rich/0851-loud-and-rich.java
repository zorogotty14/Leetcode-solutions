import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        // Build the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pair : richer) {
            graph.get(pair[1]).add(pair[0]); // Add an edge bi -> ai (ai richer than bi)
        }

        // Initialize the answer array with -1 (to indicate unvisited nodes)
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // DFS function to find the least quiet person
        // for all richer or equal nodes of a given person
        for (int i = 0; i < n; i++) {
            dfs(i, graph, quiet, answer);
        }

        return answer;
    }

    private int dfs(int person, List<List<Integer>> graph, int[] quiet, int[] answer) {
        // If answer is already computed, return it
        if (answer[person] != -1) {
            return answer[person];
        }

        // Initialize the least quiet person as the current person
        answer[person] = person;

        // Visit all neighbors (richer people)
        for (int richerPerson : graph.get(person)) {
            int candidate = dfs(richerPerson, graph, quiet, answer);
            if (quiet[candidate] < quiet[answer[person]]) {
                answer[person] = candidate; // Update if quieter person is found
            }
        }

        return answer[person];
    }
}
