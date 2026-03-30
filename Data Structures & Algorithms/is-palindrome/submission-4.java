class Solution {
    public boolean isPalindrome(String s) {

        if(s.length() == 1) return true;

        String alphanumeric = s.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println(alphanumeric);

        char[] chars = alphanumeric.toLowerCase().toCharArray();

        int head = 0;

        int tail = chars.length - 1;

        while(head < tail) {

            if(chars[head] != chars[tail]) return false;

            head++;
            tail--;
    
        }

        return true;
        
    }
}
