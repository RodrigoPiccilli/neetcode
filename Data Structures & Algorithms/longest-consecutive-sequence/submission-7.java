class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length < 2) return nums.length;

        Set<Integer> set = new HashSet<>();

        int streak = 1;

        for(int num : nums) {
            set.add(num);
        }

        for(int val : set) {

            int localStreak = 1;

            if(!set.contains(val - 1)) {

                while(set.contains(val + localStreak)) {
                    localStreak++;
                }

                streak = Math.max(localStreak, streak);

            }

        }

        return streak;


        
    }
}
