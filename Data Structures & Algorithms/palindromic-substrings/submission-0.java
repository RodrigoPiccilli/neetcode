class Solution {
    
    public int countSubstrings(String s) {

        int count = s.length();

        for(int i = 0; i < s.length(); i++) {
            count += (expand(i - 1, i + 1, s) +  expand(i, i + 1, s));
        }

        return count;
    }

    private int expand(int start, int end, String s) {

        int count = 0;

        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }

        return count;

    }
}
