class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        // Iterate through each price
        for (int i = 0; i < n; i++) {
            // Initialize the final price as the original price
            answer[i] = prices[i];
            // Find the discount
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    // Apply the discount and break the loop
                    answer[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        
        return answer;
    }
}
