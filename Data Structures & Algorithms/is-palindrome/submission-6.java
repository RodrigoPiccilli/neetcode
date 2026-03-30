class Solution {
    public boolean isPalindrome(String s) {

        if(s.length() == 1) return true;

        int p1 = 0;
        int p2 = s.length() - 1;

        String lowerCase = s.toLowerCase();

        while(p1 < p2) {

            if(!Character.isLetterOrDigit(lowerCase.charAt(p1))) {
                p1++;
                continue;
            }

            if(!Character.isLetterOrDigit(lowerCase.charAt(p2))) {
                p2--;
                continue;
            }

            if(lowerCase.charAt(p1) != lowerCase.charAt(p2)) return false;

            p1++;
            p2--;

        }

        return true;

    }


}
