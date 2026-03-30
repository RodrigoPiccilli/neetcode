class Solution {
    public boolean isAnagram(String s, String t) {

        if(s == null || t == null) return false;

        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++) {

            int accessIndex = s.charAt(i) - 'a';

            count[accessIndex]++;

        }

        for(int i = 0; i < t.length(); i++) {

            int accessIndex = t.charAt(i) - 'a';

            count[accessIndex]--;

        }

        for(int i = 0; i < count.length; i++) {

            if(count[i] != 0) return false;

        }

        return true;


    }
}
