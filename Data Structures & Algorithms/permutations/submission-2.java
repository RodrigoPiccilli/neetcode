class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, new LinkedHashSet<>(), res);

        return res;
        
    }

    private void backtrack(int[] nums, LinkedHashSet<Integer> cur, List<List<Integer>> res) {

        if(cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }


        for(int n : nums) {

            if(cur.contains(n)) continue;
            cur.add(n);
            backtrack(nums, cur, res);
            cur.remove(n);

        }



    }
}
