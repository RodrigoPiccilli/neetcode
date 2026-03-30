class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] solution = new int[nums.length];

        for(int i = 0; i < solution.length; i++) {
            solution[i] = 1;
        }

        int left = nums[0];

        for(int i = 1; i < nums.length; i++) {
            solution[i] = left;
            left *= nums[i];
        }

        int right = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            solution[i] *= right;
            right *= nums[i];
        }

        return solution;
        
    }
}  
