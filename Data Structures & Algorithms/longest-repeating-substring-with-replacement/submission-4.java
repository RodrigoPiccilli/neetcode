class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0;
        int res = 0;

        int maxFreq = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int r = 0; r < s.length(); r++) {

            char current = s.charAt(r);

            if(!map.containsKey(current)) {
                map.put(current, 0);
            }

            map.put(current, map.get(current) + 1);

            maxFreq = Math.max(map.get(current), maxFreq);

            if(r - l + 1 - maxFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(r - l + 1, res);

        }

        return res;

    }
}
