class Solution {
    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        String lower = s.toLowerCase();

        while(l < r) {

            if(!Character.isLetterOrDigit(lower.charAt(l))) {l++; continue;};
            if(!Character.isLetterOrDigit(lower.charAt(r))) {r--; continue;};

            if(lower.charAt(l) != lower.charAt(r)) return false;

            l++;
            r--;

        }

        return true;

        
    }
}
