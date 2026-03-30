class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() < 2) return s.length();

        // Use Set to Identify "Seen" Characters

        Set<Character> set = new HashSet();

        int streak = 0;

        // Keep increasing r as long as the character is not in the set.
        // If we find a duplicate, continue to increase l until we get back to no duplicates.

        int l = 0;

        for(int r = 0; r < s.length(); r++) {

            char current = s.charAt(r);

            if(set.contains(current)) {
                streak = Math.max(r - l, streak);
                while(s.charAt(l) != current) {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.remove(s.charAt(l));
                l++;
            }

            set.add(current);

        }

        return Math.max(streak, s.length() - l);
        
    }
}
