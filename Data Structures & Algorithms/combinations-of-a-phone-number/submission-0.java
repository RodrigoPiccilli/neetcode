class Solution {

    Map<Character, String> lc = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if(digits.length() == 0) return res;

        lc.put('1', "");
        lc.put('2', "abc");
        lc.put('3', "def");
        lc.put('4', "ghi");
        lc.put('5', "jkl");
        lc.put('6', "mno");
        lc.put('7', "pqrs");
        lc.put('8', "tuv");
        lc.put('9', "wxyz");

        backtrack(0, digits, "", res);

        return res;

    }

    private void backtrack(int idx, String digits, String current, List<String> res) {

        if(idx == digits.length()) {
            res.add(current);
            return;
        }

        String letters = lc.get(digits.charAt(idx));

        for(int i = 0; i < letters.length(); i++) {
            backtrack(idx + 1, digits, (current + letters.charAt(i)), res);
        }

    }
}
