class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        backtrack(0, 0, sb, res, n);

        return res;

    }

    private void backtrack(int leftCount, int rightCount, StringBuilder sb, List<String> res, int n) {

        if(rightCount > leftCount || leftCount > n) return;

        if(leftCount == rightCount && leftCount == n) {
            res.add(sb.toString());
            return;
        }

        backtrack(leftCount + 1, rightCount, sb.append("("), res, n);
        sb.deleteCharAt(sb.length() - 1);
        backtrack(leftCount, rightCount + 1, sb.append(")"), res, n);
        sb.deleteCharAt(sb.length() - 1);

    }
}
