class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int idx, int[] nums, List<Integer> current, List<List<Integer>> res) {

        if(idx >= nums.length) {

            if(!res.contains(current)){
                res.add(new ArrayList<>(current));
            }
            
            return;
        }

        current.add(nums[idx]);

        backtrack(idx + 1, nums, current, res);

        current.remove(current.size() - 1);

        backtrack(idx + 1, nums, current, res);

    }
}
