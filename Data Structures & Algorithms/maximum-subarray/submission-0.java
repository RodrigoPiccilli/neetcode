class Solution {
    public int maxSubArray(int[] nums) {
        
        int currentSum = nums[0];
        int max = nums[0];

        for (int r = 1; r < nums.length; r++) {
            
            int cur = nums[r];

            currentSum = Math.max(currentSum + cur, cur);
           
            max = Math.max(currentSum, max);
        
        }

        return max;
    }
}
