class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Variable to track longest streak
        int streak = 0;
        int windowSize = 0;
        
        // We need to track the characters that we have just seen.
        Set<Character> seen = new HashSet<>();

        // Pointer to track where substring began
        int l = 0;
        int r = 0;

        // Loop iterating through the entire string
        while(r < s.length()) {

            Character c = s.charAt(r);

            if(!seen.contains(c)) { // Character is not in the set.
                seen.add(c);
                windowSize++;
                r++;
                streak = Math.max(streak, windowSize);
            } else { // Character is in the set.
                seen.remove(s.charAt(l));
                windowSize--;
                l++;
            }
        }

        return streak;

    }
}
