class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // We need to go through the entire array to find out what it contains, since
        // it is not sorted. We can use a HashMap to store what index we have looked at 
        // and what that index contains.

        // Key = Number, Value = Index 
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Iterate through MAP to find complement.
        // We iterate through the map in order to avoid duplicates.

        for(int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if(map.get(complement) != null && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }


        }

        return new int[2];
    }
}
