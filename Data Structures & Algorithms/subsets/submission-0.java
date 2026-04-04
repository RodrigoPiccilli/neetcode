class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        backtrack(0, res, current, nums);

        return res;

    }

    private void backtrack(int index, List<List<Integer>> res, List<Integer> current, int[] nums) {

        if(index == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrack(index + 1, res, current, nums);
        current.remove(current.size() - 1);
        backtrack(index + 1, res, current, nums);

    }
}
