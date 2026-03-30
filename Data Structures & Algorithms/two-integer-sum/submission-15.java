class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Use HashMap to map (index, difference)

        HashMap<Integer, Integer> map = new HashMap(); // O(n) Space

        for(int i = 0; i < nums.length; i++) { // O(n)
            map.put(target - nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) { // O(n)
            if(map.get(nums[i]) != null && map.get(nums[i]) != i) {
                int[] solution = {i, map.get(nums[i])};
                return solution;
            }
        }

        return new int[2];

    }
}
