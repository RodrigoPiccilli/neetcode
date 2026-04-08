class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        backtrack(0, candidates, new ArrayList<>(), res, target);

        return res;
        
    }


    //[1,2,2,4,5,6,9]

    private void backtrack(int idx, int[] candidates, List<Integer> cur, List<List<Integer>> res, int target) {

        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = idx; i < candidates.length; i++) {

            if(target - candidates[i] < 0) break;

            cur.add(candidates[i]);
            backtrack(i + 1, candidates, cur, res, target - candidates[i]);
            cur.remove(cur.size() - 1);

            while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }

        }




    }
}
