class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        // Brute Force

        // Sorting (nLog(n))

        // HashSet log(1)

        HashSet<Integer> set = new HashSet();

        if(nums.length < 2) return false;

        for(int i : nums) { // O(n)
            if(!set.add(i)) return true;
        }

        return false;
    

    }
}