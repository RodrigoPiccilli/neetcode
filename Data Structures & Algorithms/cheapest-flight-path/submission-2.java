class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // [k] -> Level of BFS, [n] -> Node cost at that level
        int[] prices = new int[n];

        for(int i = 0; i < n; i++) prices[i] = Integer.MAX_VALUE;

        prices[src] = 0;

        for(int i = 0; i <= k; i++) {

            int[] temp = Arrays.copyOf(prices, n);

            for(int[] flight : flights) {

                int s = flight[0];

                int d = flight[1];

                int c = flight[2];

                if(prices[s] == Integer.MAX_VALUE) continue;

                if(temp[d] > prices[s] + c) {
                    temp[d] = prices[s] + c;
                }


            }

            prices = Arrays.copyOf(temp, n);


        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];

    }
}
