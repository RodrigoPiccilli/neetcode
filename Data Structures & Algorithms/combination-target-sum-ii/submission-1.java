class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<>();

        backtrack(0, candidates, new ArrayList<>(), res, target);

        return res;

    }

    private void backtrack(int idx, int[] candidates, List<Integer> current, List<List<Integer>> res, int target) {

        if(target == 0) {
            res.add(new ArrayList<>(current));
        }

        for(int i = idx; i < candidates.length; i++) {

            if(i > idx && candidates[i] == candidates[i - 1]) continue;

            if(target - candidates[i] < 0) break;

            current.add(candidates[i]);

            backtrack(i + 1, candidates, current, res, target - candidates[i]);

            current.remove(current.size() - 1);

        }


    }
}
