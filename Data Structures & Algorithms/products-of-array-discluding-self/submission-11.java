class Solution {
    public int[] productExceptSelf(int[] nums) {

        // nums -> 1, 2, 4, 6

        // first pass -> 1, 1, 2, 8

        // second pass -> 48, 24, 12, 8

        int[] solution = new int[nums.length];
        
        int count = 1;

        for(int i = 0; i < nums.length; i++) {
            solution[i] = count;
            count *= nums[i];
        }

        count = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {

            solution[i] *= count;
            count *= nums[i];

        }

        return solution;
        
    }
}  
