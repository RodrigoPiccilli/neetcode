class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        backtrack(nums, current, res);
    
        return res;

    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> res) {

        if(current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        for(int n : nums) {

            if(current.contains(n)) continue;
            current.add(n);
            backtrack(nums, current, res);
            current.remove(current.size() - 1);

        }

    }
}
