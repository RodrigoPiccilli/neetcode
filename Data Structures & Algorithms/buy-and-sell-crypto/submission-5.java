class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;

        if(prices.length == 1) return profit;

        int left = 0;
        int right = 0;

        while(right < prices.length) {

            int diff = prices[right] - prices[left];

            if(diff >= 0) {
                profit = Math.max(profit, diff);
                right++;
            } else if(diff < 0) {
                left = right;
            }

        }

        return profit;
        
    }
}
