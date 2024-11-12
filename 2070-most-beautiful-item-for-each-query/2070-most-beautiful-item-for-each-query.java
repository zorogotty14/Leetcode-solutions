import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price (ascending) and by beauty (descending for tie-breaking)
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        // Sort queries while keeping track of original indices
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[queries.length];
        int maxBeauty = 0;
        int index = 0;
        
        // Iterate over sorted queries and find max beauty using a two-pointer approach
        for (int i = 0; i < sortedQueries.length; i++) {
            int query = sortedQueries[i][0];
            
            // Increase max beauty as we traverse items with price <= current query
            while (index < items.length && items[index][0] <= query) {
                maxBeauty = Math.max(maxBeauty, items[index][1]);
                index++;
            }
            
            // Store the result in the original index of the query
            result[sortedQueries[i][1]] = maxBeauty;
        }
        
        return result;
    }
}
