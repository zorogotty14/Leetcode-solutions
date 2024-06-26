class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }
        
        // State array to track the visit status of each node
        int[] visit = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited
        
        // Perform DFS to detect cycles
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0 && hasCycle(graph, visit, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int[] visit, int course) {
        if (visit[course] == 1) {
            return true; // cycle detected
        }
        if (visit[course] == 2) {
            return false; // already processed
        }
        
        visit[course] = 1; // mark as visiting
        for (int neighbor : graph.get(course)) {
            if (hasCycle(graph, visit, neighbor)) {
                return true;
            }
        }
        visit[course] = 2; // mark as visited
        return false;
    }
}