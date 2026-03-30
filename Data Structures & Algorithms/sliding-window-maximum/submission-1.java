class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int[] max = new int[nums.length - k + 1];

        int l = 0;

        for(int i = 0; i < k; i++) {

            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }   

            map.put(nums[i], map.get(nums[i]) + 1);

        }

        max[0] = map.lastKey();

        for(int r = k; r < nums.length; r++) {

            if(map.get(nums[l]) != 1){
                map.put(nums[l], map.get(nums[l]) - 1);
            } else {
                map.remove(nums[l]);
            }

            l++;

            if(!map.containsKey(nums[r])) {
                map.put(nums[r], 0);
            }

            map.put(nums[r], map.get(nums[r]) + 1);
            
            max[l] = map.lastKey();

        }

        return max;

    }
}
