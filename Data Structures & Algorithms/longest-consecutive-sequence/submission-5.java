class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length < 2) return nums.length;

        Set<Integer> set = new HashSet<>();

        int streak = 1;

        for(int num : nums) {
            set.add(num);
        }

        for(int num : set) {

            if(!set.contains(num - 1)) {

                int temp = num + 1;

                int localStreak = 1;

                while(set.contains(temp++)) {
                    localStreak++;
                }

                streak = Math.max(localStreak, streak);

            }

        }

        return streak;
        
    }
}
