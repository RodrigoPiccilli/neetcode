class Solution {
    public int[] twoSum(int[] nums, int target) {

     
        // KEY: Value ; VALUE: Index
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if(map.containsKey(complement) && map.get(complement) != i) {

                int solution[] = {i, map.get(complement)};
                
                return solution;

            }

        }

        return null;

    }
}
