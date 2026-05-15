class Solution {

    int[] cache;

    public int climbStairs(int n) {
        
        cache = new int[n + 1];

        Arrays.fill(cache, -1);

        return dp(n);

    }

    private int dp(int n) {

        if(n < 0) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        if(cache[n] != -1) {
            return cache[n];
        }

        cache[n] = dp(n - 2) + dp(n - 1);

        return cache[n];


    }
}
