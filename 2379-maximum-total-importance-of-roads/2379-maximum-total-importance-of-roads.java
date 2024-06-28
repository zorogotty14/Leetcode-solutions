class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // Array to store the degree of each city
        int[] degree = new int[n];
        
        // Calculate the degree of each city
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        // Pair each city with its degree and sort by degree in descending order
        Integer[] cities = new Integer[n];
        for (int i = 0; i < n; i++) {
            cities[i] = i;
        }
        
        Arrays.sort(cities, (a, b) -> degree[b] - degree[a]);
        
        // Assign the highest values to the cities with the highest degrees
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[cities[i]] = n - i;
        }
        
        // Calculate the total importance of all roads
        long totalImportance = 0;
        for (int[] road : roads) {
            totalImportance += values[road[0]] + values[road[1]];
        }
        
        return totalImportance;
    }
}