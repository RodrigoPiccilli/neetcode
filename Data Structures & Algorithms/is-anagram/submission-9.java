class Solution {
    public boolean isAnagram(String s, String t) {

        // Anagrams have the same length, therefore we can return if not

        if(s.length() != t.length()) return false;

        char[] s1 = new char[26];
        char[] s2 = new char[26];

        for(int i = 0; i < s.length(); i++) {
            s1[s.charAt(i) - 'a']++;
            s2[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(s1[i] != s2[i]) return false;
        }

        return true;

    }
}
