class Solution {
   
    int N;

    public int minCostClimbingStairs(int[] cost) {
        
        N = cost.length;

        int[] cache = new int[N];

        cache[0] = cost[0];
        cache[1] = cost[1];

        for(int i = 2; i < N; i++) {
            cache[i] = Math.min(cache[i - 1], cache[i - 2]) + cost[i];
        }

        return Math.min(cache[N - 1], cache[N - 2]);
    }

}
