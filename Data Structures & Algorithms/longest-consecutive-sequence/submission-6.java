class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length <= 1) return nums.length;

        Set<Integer> set = new HashSet<>();

        int longest = 1;

        for(int num : nums) {
            set.add(num);
        }

        for(int num : set) {

            int localLongest = 1;

            if(!set.contains(num - 1)) {

                int count = num;

                while(set.contains(count + 1)) {
                    count++;
                    localLongest++;
                }

                longest = Math.max(longest, localLongest);

            }
        }

        return longest;
        
    }
}
