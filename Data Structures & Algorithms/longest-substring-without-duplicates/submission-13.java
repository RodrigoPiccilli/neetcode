class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();

        // KEY = Character, VALUE = Index
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;

        int res = 0;

        map.put(s.charAt(l), 0);

        for (int r = 1; r < s.length(); r++) {
            char c = s.charAt(r);

            if (map.containsKey(c)) {
                if (map.get(c) >= l) {
                    l = map.get(c) + 1;
                }
            }

            res = Math.max(res, (r - l) + 1);

            map.put(c, r);
        }

        return res;
    }
}
