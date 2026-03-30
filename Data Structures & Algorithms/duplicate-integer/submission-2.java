class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {

            if(map.get(num) == null) map.put(num, 0);

            map.put(num, map.get(num) + 1);

            if(map.get(num) > 1) return true;

        }

        return false;
        
    }
}