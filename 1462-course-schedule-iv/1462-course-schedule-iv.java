class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Create a 2D boolean matrix to store reachability information
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        // Step 2: Initialize the matrix with direct prerequisites
        for (int[] prerequisite : prerequisites) {
            isPrerequisite[prerequisite[0]][prerequisite[1]] = true;
        }

        // Step 3: Use Floyd-Warshall algorithm to compute transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrerequisite[i][k] && isPrerequisite[k][j]) {
                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }

        // Step 4: Answer the queries using the reachability matrix
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrerequisite[query[0]][query[1]]);
        }

        return result;
    }
}