class Solution {
    public int[] productExceptSelf(int[] nums) {


        int[] solution = new int[nums.length]; // Same length as initial array

        for(int i = 0; i < nums.length; i++) {
            solution[i] = 1;
        }

        // Idea: Multiply each value in solution by the left values of original nums array
        // Then multiply each value in solution by the right values of original nums array

        // [1, 2, 4, 6]     [-1, 0, 1, 2, 3]
        // [1, 1, 2, 8]     [1, -1, 0, 0, 0]


        int count = nums[0];

        // Left Multiplication
        for(int i = 1; i < nums.length; i++) {
            solution[i] = count;
            count *= nums[i];
        }

        count = nums[nums.length - 1];


        // Right Multiplication
        for(int i = nums.length - 2; i >= 0; i--) {
            solution[i] *= count;
            count *= nums[i];
        }
        

        return solution;
    }
}  
