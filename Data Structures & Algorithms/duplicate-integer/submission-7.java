class Solution {
    public boolean hasDuplicate(int[] nums) {

        // We can use a hash set to register which elements have already been seen.
        HashSet<Integer> set = new HashSet();

        for(int num : nums) {
            if(!set.add(num)) return true; // If we fail to add to set because it already exists, return true.
        }

        return false; // If we make through the entire input without failing to add to set, return false.
        
    }
}