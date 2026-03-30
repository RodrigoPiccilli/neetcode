class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0;

        int maxLength = 0;

        int maxFreq = 0;

        // KEY = char, VALUE = frequency
        Map<Character, Integer> freq = new HashMap<>();

        for(int r = 0; r < s.length(); r++) {

            char current = s.charAt(r);

            if(!freq.containsKey(current)) {
                freq.put(current, 0);
            }

            freq.put(current, freq.get(current) + 1);

            maxFreq = Math.max(maxFreq, freq.get(current));

            // Window Size - Frequency needs to be less than K
            while(r - l + 1 - maxFreq > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);

        }

        return maxLength;

    }
}
