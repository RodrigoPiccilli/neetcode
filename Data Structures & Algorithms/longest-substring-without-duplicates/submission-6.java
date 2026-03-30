class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() < 2) return s.length();

        Set<Character> set = new HashSet();

        int l = 0;

        int r = 0;

        int champion = 0;

        while(r < s.length()) {

            char current = s.charAt(r);

            if(set.contains(current)) {
                champion = Math.max(champion, (r - l));
                while(set.contains(current)) {
                    set.remove(s.charAt(l++));
                }
            }

            set.add(current);
            r++;

        }

        champion = Math.max(champion, (r - l));

        return champion;


        
        
    }
}
