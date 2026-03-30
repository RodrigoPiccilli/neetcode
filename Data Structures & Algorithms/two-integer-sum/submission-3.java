class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }


        for(int i = 0; i < nums.length; i++) {

            int magicNumber = target - nums[i];

            if(map.containsKey(magicNumber) && map.get(magicNumber) != i) {

                return new int[] {i, map.get(magicNumber)};

            }

            

        }

        return new int[0];

    }
}
