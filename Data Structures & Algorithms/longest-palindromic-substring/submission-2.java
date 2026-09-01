class Solution {
    public String longestPalindrome(String s) {

        int[] range = new int[] {0, 0};

        for(int i = 0; i < s.length(); i++) {
            expand(i, i, s, range);
            expand(i, i + 1, s, range);
        }

        return s.substring(range[0], range[1] + 1);

    }

    private void expand(int left, int right, String s, int[] range) {

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            if(right - left + 1 > range[1] - range[0] + 1) {
                range[1] = right;
                range[0] = left;
            }

            left--;
            right++;

        }

    }
}
