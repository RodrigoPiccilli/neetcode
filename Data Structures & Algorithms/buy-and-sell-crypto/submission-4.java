class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;

        int l = 0;

        for(int r = 1; r < prices.length; r++) {

            System.out.println(r + " : " + l + " : " + (prices[r] - prices[l]));

            if(prices[l] > prices[r]) {
                r = l;
                l++;
                continue;
            }

            profit = Math.max(prices[r] - prices[l], profit);

        }
        
       
        return profit;
    }

}
