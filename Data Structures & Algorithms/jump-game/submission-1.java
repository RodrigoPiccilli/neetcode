class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReach = nums[0];

        for(int i = 0; i < nums.length - 1; i++) {

            if(maxReach < i) return false;

            maxReach = Math.max(maxReach, nums[i] + i);

        }

        return maxReach >= nums.length - 1;

    }
}
