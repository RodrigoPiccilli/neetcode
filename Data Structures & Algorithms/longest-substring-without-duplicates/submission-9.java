class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;

        int l = 0;

        int maxLength = 0;

        Set<Character> window = new HashSet<>();

        for(int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);

            while(window.contains(c)) {

                window.remove(s.charAt(l++));

            }

            window.add(c);

            maxLength = Math.max(window.size(), maxLength);

        }

        return maxLength;


        
    }
}
