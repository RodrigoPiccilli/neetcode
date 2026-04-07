class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, res, current);

        return res;

    }

    private void backtrack(int idx, int[] nums, List<List<Integer>> res, List<Integer> current) {

        if(idx >= nums.length) {
            res.add(new ArrayList<>(current));
            return;   
        }

        current.add(nums[idx]);
        backtrack(idx + 1, nums, res, current);
        current.remove(current.size() - 1);
        backtrack(idx + 1, nums, res, current);

    }
}
