class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        int max = 0;

        for(int n : set) {

            if(!set.contains(n - 1)) { // Start of sequence
                int cur = n;

                while(set.contains(cur)) {
                    cur += 1;
                }

                max = Math.max(max, cur - n);

            }

        }

        return max;

    }
}
