class Solution {
    public int maxProfit(int[] prices) {
        
        // Track max profit
        int profit = 0;

        int l = 0;

        for(int r = 1; r < prices.length; r++) {

            if(prices[l] <= prices[r]) {
                profit = Math.max(prices[r] - prices[l], profit);
            } else {
                l = r;
            }

        }

        return profit;
    }


}
