class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Use HashMap to register each number seen, as well as the index seen at.

        // key = number, value = index
        HashMap<Integer, Integer> map = new HashMap();


        // Loop through input, adding each number and their index while checking for the complement.
        for(int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }

        return new int[2];


    }
}
