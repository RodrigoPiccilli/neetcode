class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Use HashMap to track numbers seen, and what index we have seen them at.

        Map<Integer, Integer> map = new HashMap<>();

        // KEY = Number, VALUE = Index

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Loop through array again, referring the map to check if current index
        // has a complement later in the list.

        for(int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }

        }

        return new int[2];
        
    }
}
