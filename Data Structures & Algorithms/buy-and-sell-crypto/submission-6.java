class Solution {
    public int maxProfit(int[] prices) {
        
        int l = 0, r = 0;

        int best = 0;

        while(r < prices.length) {

            int current = prices[r] - prices[l];

            best = Math.max(current, best);

            if(l == r || prices[l] < prices[r]) {
                r++;
            } else {
                l++;
            }

        }

        return best;

    }
}
