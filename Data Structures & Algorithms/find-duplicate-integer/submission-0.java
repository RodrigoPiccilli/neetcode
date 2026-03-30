class Solution {
    public int findDuplicate(int[] nums) {

        if(nums.length == 2) return nums[0];

        for(int i = 0; i < nums.length; i++) {

            //  [1, -2, -3, -2, 2] -> nums[i] = next index we will negate.

            //  [0, 1, 2, 3, 4] -> Corresponding Indexes

            int negationIndex = Math.abs(nums[i]);

            if(nums[negationIndex] < 0) return Math.abs(nums[i]);

            nums[negationIndex] *= -1;

        }

        return 0;
        
    }
}
