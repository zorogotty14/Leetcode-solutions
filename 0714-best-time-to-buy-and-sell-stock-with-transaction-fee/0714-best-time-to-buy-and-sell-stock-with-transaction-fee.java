class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;

        // Variables to track the maximum profit
        int cash = 0;  // Maximum profit we can have if we do not own a stock
        int hold = -prices[0];  // Maximum profit we can have if we own a stock

        for (int i = 1; i < n; i++) {
            // Update cash to reflect selling the stock
            cash = Math.max(cash, hold + prices[i] - fee);
            // Update hold to reflect buying the stock
            hold = Math.max(hold, cash - prices[i]);
        }

        // The result is the maximum profit without holding a stock
        return cash;
    }
}
