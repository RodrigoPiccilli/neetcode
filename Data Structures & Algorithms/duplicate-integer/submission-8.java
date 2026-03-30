class Solution {
    public boolean hasDuplicate(int[] nums) {

        if(nums.length >= 2) {

            // HashSets are used to identify duplicates.

            Set<Integer> set = new HashSet();

            for(int n : nums) {
                if(!set.add(n)) return true;
            }
        }

        return false;
        
    }
}