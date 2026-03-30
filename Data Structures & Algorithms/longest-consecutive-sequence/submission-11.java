class Solution {
    public int longestConsecutive(int[] nums) {
            
        // Create a set to remove duplicates and store which elements are in the list.

        Set<Integer> set = new HashSet();

        for(int n : nums) {
            set.add(n);
        }

        int longest = 0;

        // Iterate through set. If the number we are currently on does not have a number in the set
        // that is to its left, it is the start of a new sequence.

        for(int n : set) {

            if(!set.contains(n - 1)) {

                int streak = 1;

                while(set.contains(n + streak)) {
                    streak++;
                }

                longest = Math.max(longest, streak);
            }

        }

        return longest;

    }
}
