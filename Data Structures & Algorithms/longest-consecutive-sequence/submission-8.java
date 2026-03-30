class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        int streak = 1;

        Set<Integer> set = new HashSet();

        for(int num : nums){
            set.add(num);
        }

        for(int num : set) {

            int localCount = 1;

            if(!set.contains(num - 1)) {
                while(set.contains(num + localCount)) {
                    localCount++;
                }
                streak = Math.max(streak, localCount);
            }

        }

        return streak;
        
    }
}
