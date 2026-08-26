class Solution {
    int[] cache;
    public int rob(int[] nums) {

        cache = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            cache[i] = -1;
        }

        return dfs(0, nums);
    }

    private int dfs(int i, int[] nums) {

        if(i >= nums.length) return 0;

        if(cache[i] != -1) return cache[i];

        cache[i] = Math.max(dfs(i + 2, nums) + nums[i], dfs(i + 1, nums));

        return cache[i];

    }
}
