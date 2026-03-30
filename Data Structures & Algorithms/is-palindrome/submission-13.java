class Solution {
    public boolean isPalindrome(String s) {

        String copy = s.toLowerCase();

        int left = 0;

        int right = copy.length() - 1;

        while(left <= right) {

            char lc = copy.charAt(left);
            char rc = copy.charAt(right);

            if(!Character.isLetterOrDigit(lc)) {
                left++; 
                continue;
            }

            if(!Character.isLetterOrDigit(rc)) {
                right--;
                continue;
            }

            if(lc != rc) return false;

            left++;
            right--;

        }

        return true;
        
    }
}

