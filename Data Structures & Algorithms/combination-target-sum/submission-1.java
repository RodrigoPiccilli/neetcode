class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, res, current, target);

        return res;

     
    }

    private void backtrack(int idx, int[] nums, List<List<Integer>> res, List<Integer> current, int target) {

        if(target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i < nums.length; i++) {

            if(target - nums[i] < 0) break;

            current.add(nums[i]);

            backtrack(i, nums, res, current, target - nums[i]);
            
            current.remove(current.size() - 1);

        }

    }
}
