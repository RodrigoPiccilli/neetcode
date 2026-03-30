class Solution {
    public int[] productExceptSelf(int[] nums) {

        int count = nums[0];

        int[] solution = new int[nums.length];

        solution[0] = 1;

        // NUMS: [1, 2, 4, 6]
        // SOL: [1, 0, 0, 0]

        for(int i = 1; i < nums.length; i++) {
            solution[i] = count;
            count *= nums[i];
        }

        // INTERMEDIATE: [1, 1, 2, 8]

        count = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            solution[i] *= count;
            count *= nums[i];
        }

        return solution;

        
    }
}  
