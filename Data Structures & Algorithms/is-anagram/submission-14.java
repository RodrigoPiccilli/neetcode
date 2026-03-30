class Solution {
    public boolean isAnagram(String s, String t) {


        if(s.length() != t.length()) return false;

        int len = s.length();

        // Since the strings are lowercase, we know that all words will consists of
        // characters from a-z. Therefore, there is no need to use a hashmap, since we are
        // dealing with a finite number of possible frequencies. We will use a count array.

        int[] count = new int[26];

        for(int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int n : count) {
            if(n != 0) return false;
        }

        return true;

    }
}
