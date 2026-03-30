class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Use a HashMap. This allows us to remember where we have seen each number.


        // KEY = Number
        // VALUE = Index
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            
            if(map.get(complement) != null && map.get(complement) != i) {

                return new int[] {map.get(complement), i};

            }

            map.put(nums[i], i);

        }

        return new int[2];

    }
}
