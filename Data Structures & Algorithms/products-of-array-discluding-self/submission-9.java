class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] solution = new int[nums.length];

        int running = nums[0];

        for(int i = 0; i < solution.length; i++) {
            solution[i] = 1;
        }

        for(int i = 1; i < nums.length; i++) {
            solution[i] = running;
            running *= nums[i];
        }

        running = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            solution[i] *= running;
            running *= nums[i];
        }

        return solution;
        
    }
}  
