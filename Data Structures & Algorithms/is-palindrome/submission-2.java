class Solution {
    public boolean isPalindrome(String s) {

        String palindrome = s.replaceAll("[^0-9A-z]", "");
        palindrome = palindrome.trim();
    
        if(palindrome.length() < 2) return true;
    
        if(palindrome.toLowerCase().charAt(0) == palindrome.toLowerCase().charAt(palindrome.length() - 1)) {
            return isPalindrome(palindrome.substring(1, palindrome.length() - 1));
        }



        return false;


    }
}
