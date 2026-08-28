class Solution {
    int[][] cache;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        cache = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            cache[i][0] = -1;
            cache[i][1] = -1;
        }

        return Math.max(helper(0, nums.length - 1, nums, 0), helper(1, nums.length, nums, 1));
    }

    private int helper(int start, int end, int[] nums, int cacheDimension) {

        if (start >= end) {
            return 0;
        }

        if (cache[start][cacheDimension] != -1) {
            return cache[start][cacheDimension];
        }

        return cache[start][cacheDimension] = Math.max(helper(start + 2, end, nums, cacheDimension) + nums[start],
        helper(start + 1, end, nums, cacheDimension));
    }
}
