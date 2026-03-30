class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;

        if(prices.length == 1) return profit;
 
        int l = 0;
        
        for(int r = 1; r < prices.length; r++) {

            if(prices[l] >= prices[r]) {
                l = r;
                continue;
            }

            profit = Math.max(prices[r] - prices[l], profit);


        }

        return profit;

    }
}
