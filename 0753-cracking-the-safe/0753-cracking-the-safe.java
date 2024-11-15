import java.util.*;

class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder result = new StringBuilder();
        Set<String> visited = new HashSet<>();
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            start.append('0'); // Initialize with "000...(n-1 times)"
        }
        dfs(start.toString(), k, visited, result);
        result.append(start); // Append the initial prefix to cover all states
        return result.toString();
    }

    private void dfs(String node, int k, Set<String> visited, StringBuilder result) {
        for (int i = 0; i < k; i++) {
            String next = node + i;
            if (!visited.contains(next)) {
                visited.add(next);
                dfs(next.substring(1), k, visited, result);
                result.append(i); // Add the digit to the result
            }
        }
    }
}
