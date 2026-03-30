class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet();

        for(int n : nums) {
            set.add(n);
        }

        int longest = 1;

        for(int n : set) {
            
            int streak = 1;

            for(int i = n + 1; !set.contains(n - 1) && set.contains(i); i++) {
                streak++;
            }

            longest = Math.max(longest, streak);

        }
        
        return longest;
    }
}
