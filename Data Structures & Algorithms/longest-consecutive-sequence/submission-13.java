class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        int max = 0;

        for(int n : set) {

            if(!set.contains(n - 1)) { // Start of sequence
                int cur = 1;

                while(set.contains(n + cur)) {
                    cur += 1;
                }

                max = Math.max(max, cur);

            }

        }

        return max;

    }
}
