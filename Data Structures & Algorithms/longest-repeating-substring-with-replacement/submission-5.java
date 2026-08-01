class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 1;

        int maxFreq = 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(l), 1);

        while (r < s.length()) {
            char c = s.charAt(r);

            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);

            if (map.get(c) > maxFreq) {
                maxFreq++;
            }

            if (r - l + 1 - maxFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            r++;
        }
        return r - l;
    }
}
