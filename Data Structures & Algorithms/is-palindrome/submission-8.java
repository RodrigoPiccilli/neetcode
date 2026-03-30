class Solution {
    public boolean isPalindrome(String s) {

        if(s.length() == 1) return true;

        int l = 0;
        int r = s.length() - 1;

        char[] chars = s.toLowerCase().toCharArray();

        while(l < r) {

            if(!Character.isLetterOrDigit(chars[l])) {
                l++;
                continue;
            }

            if(!Character.isLetterOrDigit(chars[r])) {
                r--;
                continue;
            }

            if(chars[l] != chars[r]) return false;

            l++;
            r--;

        }

        return true;
        
    }
}
