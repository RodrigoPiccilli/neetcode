class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] solution = new int[n];

        int running = nums[0];

        for(int i = 0; i < solution.length; i++){
            solution[i] = 1;
        }

        for(int i = 1; i < n; i++) {
           solution[i] = running;
           running *= nums[i];
        }

        running = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            solution[i] *= running;
            running *= nums[i];
        }

        return solution;
        
    }
}  
