class Solution {
    public boolean isPalindrome(String s) {

        if(s.length() == 1) return true;

        int l = 0;
        int r = s.length() - 1;

        String lower = s.toLowerCase().trim();

        while(l <= r) {
            
            if(!isValid(lower.charAt(l))) {
                l++;
                continue;
            }

             if(!isValid(lower.charAt(r))) {
                r--;
                continue;
            }

            if(lower.charAt(l++) != lower.charAt(r--)) {
                return false;
            }

        }

        return true;
        
    }

    private boolean isValid(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

}
