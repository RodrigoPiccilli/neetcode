class Solution {
    public boolean isPalindrome(String s) {

        int n = s.length();

        if(n < 2) return true;

        int l = 0;
        int r = n - 1;

        String copy = new String(s.toLowerCase());

        while(l <= r) {

            char left = copy.charAt(l);
            char right = copy.charAt(r);

            if(!Character.isLetterOrDigit(left)) {
                l++;
                continue;
            }
            
            if(!Character.isLetterOrDigit(right)) {
                r--;
                continue;
            }


            if(left != right) {
                System.out.println(left + " : " + right);
                return false;
            }

            l++;
            r--;

        }

        return true;
    }
}
