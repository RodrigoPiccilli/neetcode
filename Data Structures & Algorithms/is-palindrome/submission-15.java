class Solution {
    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        String copy = s.toLowerCase();
        
        while(l < r) {

            char start = copy.charAt(l);
            char end = copy.charAt(r);

            if(!Character.isLetterOrDigit(start)) {
                l++;
                continue;
            }

            if(!Character.isLetterOrDigit(end)) {
                r--;
                continue;
            }
            
            if(start != end) return false;

            l++;
            r--;

        }

        return true;

        
    }
}
