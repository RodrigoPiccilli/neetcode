class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robLinear(nums, 0, nums.length - 1), 
                        robLinear(nums, 1, nums.length));
    }

    private int robLinear(int[] nums, int start, int end) {
        
        int prev1 = 0; 
        int prev2 = 0; 

        for (int i = start; i < end; i++) {
            int temp = prev1;
            prev1 = Math.max(nums[i] + prev2, prev1);
            prev2 = temp;
        }

        return prev1;
    }
}