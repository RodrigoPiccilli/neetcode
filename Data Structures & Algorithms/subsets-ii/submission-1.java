class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), res);

        return res;

    }

    private void backtrack(int idx, int[] nums, List<Integer> current, List<List<Integer>> res) {

        res.add(new ArrayList<>(current));

        for(int i = idx; i < nums.length; i++) {

            if(i > idx && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);

            backtrack(i + 1, nums, current, res);

            current.remove(current.size() - 1);

        }

    }
}
