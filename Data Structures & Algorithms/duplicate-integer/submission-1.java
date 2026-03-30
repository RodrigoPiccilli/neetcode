class Solution {
    public boolean hasDuplicate(int[] nums) {

        if(nums == null) return false;

        if(nums.length < 2) return false;

        HashMap<Integer, Integer> hash = new HashMap<>();

        for(int n : nums) {

            if(hash.containsKey(n)) return true;

            hash.put(n, n);

        }

        return false;
    }
}