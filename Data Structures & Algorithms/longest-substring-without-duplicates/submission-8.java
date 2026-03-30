class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int maxLength = 0;
        Set<Character> seen = new HashSet<>();

        for(int r = 0; r < s.length(); r++) {

            char current = s.charAt(r);

            while(seen.contains(current)) {
                seen.remove(s.charAt(l));
                l++;
            }
            
            seen.add(current);
            
            maxLength = Math.max(maxLength, r - l + 1);


        }

        return maxLength;


        
    }
}
