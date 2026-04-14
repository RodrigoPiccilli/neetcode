class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if(digits.length() == 0) return res;

        String[] options = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, "", res, options);

        return res;
        
    }

    private void backtrack(int idx, String digits, String current, List<String> res, String[] options) {

        if(current.length() == digits.length()) {
            res.add(current);
            return;
        }

        int digit = digits.charAt(idx) - '0';

        String letters = options[digit];

        for(int i = 0; i < letters.length(); i++) {

            backtrack(idx + 1, digits, current + letters.charAt(i), res, options);

        }

    }
}
