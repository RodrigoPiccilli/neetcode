class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        Set<List<Integer>> res = new HashSet<>();

        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, target, res, current, 0);

        return new ArrayList<List<Integer>>(res);

    }

    private void backtrack(int index, int[] nums, int target, 
        Set<List<Integer>> res, List<Integer> current, int currentSum) {

            if(index >= nums.length) {
                return;
            } else if(currentSum == target) {
                res.add(new ArrayList<>(current));
                return;
            }

            if((currentSum + nums[index]) <= target) {
                current.add(nums[index]);
                backtrack(index, nums, target, res, current, currentSum + nums[index]);
                backtrack(index + 1, nums, target, res, current, currentSum + nums[index]);
                current.remove(current.size() - 1);
            }
            backtrack(index + 1, nums, target, res, current, currentSum);

    }
}
