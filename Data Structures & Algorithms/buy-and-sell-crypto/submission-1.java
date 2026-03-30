class Solution {
    public int maxProfit(int[] prices) {
        
        int l = 0;
        int r = 1;

        int best = 0;

        while(r < prices.length) {

            if(prices[l] < prices[r] ) {
                int profit = prices[r] - prices[l];
                best = Math.max(profit, best);
            } else {
                l = r;
            }

            r++;

        }

        return best;


    }
}
