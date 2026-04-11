class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        backtrack(0, new ArrayList<>(), res, s);

        return res;
    }

    private void backtrack(int idx, List<String> current, List<List<String>> res, String s) {

        if(idx == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i < s.length(); i++) {

            String left = s.substring(idx, i + 1);

            if(!isPalindrome(left)) continue;

            current.add(left);

            backtrack(i + 1, current, res, s);

            current.remove(current.size() - 1);

        }


    }

    private boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }

        return true;

    }
}
