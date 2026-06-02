class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        char[] w1 = s.toCharArray();
        char[] w2 = t.toCharArray();

        Arrays.sort(w1);
        Arrays.sort(w2);

        
        return Arrays.equals(w1, w2);


    }
}
