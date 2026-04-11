class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();

        backtrack(0, 0, "", res, n);

        return res;

    }

    private void backtrack(int leftCount, int rightCount, String current, List<String> res, int n) {

        if(rightCount > leftCount || leftCount > n) return;

        if(leftCount == rightCount && leftCount == n) {
            res.add(current);
            return;
        }

        backtrack(leftCount + 1, rightCount, (current + "("), res, n);
        backtrack(leftCount, rightCount + 1, (current + ")"), res, n);


    }
}
