import java.util.*;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // Create a map to store each employee by their ID
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        
        // Call DFS to calculate the total importance
        return dfs(employeeMap, id);
    }
    
    private int dfs(Map<Integer, Employee> employeeMap, int id) {
        // Get the employee by ID
        Employee employee = employeeMap.get(id);
        int totalImportance = employee.importance;
        
        // Traverse each subordinate and sum their importance recursively
        for (int subId : employee.subordinates) {
            totalImportance += dfs(employeeMap, subId);
        }
        
        return totalImportance;
    }
}
