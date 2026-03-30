class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] solution = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {

            int localProduct = 1;

            for(int j = 0; j < nums.length; j++) {

                if(j != i) {
                    localProduct *= nums[j];
                }

            }

            solution[i] = localProduct;

        }

        return solution;
    }
}  
