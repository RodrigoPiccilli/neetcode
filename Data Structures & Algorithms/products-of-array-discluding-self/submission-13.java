class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        int carry = 1;

        for(int i = 0; i < nums.length; i++) {
            res[i] = carry;
            carry *= nums[i];
        }

        carry = 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= carry;
            carry *= nums[i];
        }

        return res;
        
    }
}  
