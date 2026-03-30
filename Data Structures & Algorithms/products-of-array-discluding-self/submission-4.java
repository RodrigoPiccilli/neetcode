class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] solution = new int[nums.length];

        for(int i = 0; i < solution.length; i++) {

            int forward = 1;

            for(int j = i + 1; j < solution.length; j++) {
                forward *= nums[j];
            }

            solution[i] = forward;

        }
        
        for(int i = solution.length - 1; i >= 0; i--) {

            int backward = 1;

            for(int j = i - 1; j >= 0; j--) {
                backward *= nums[j];
            }

            solution[i] *= backward;

        }

        return solution;
    }
}  
