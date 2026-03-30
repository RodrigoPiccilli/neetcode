class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Set<Integer> count = new HashSet<>();

        for(int num : nums) {
            if(count.contains(num)) return true;
            count.add(num);
        }

        return false;

    }
}