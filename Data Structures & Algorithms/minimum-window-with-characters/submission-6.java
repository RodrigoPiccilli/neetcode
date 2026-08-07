class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] res = new int[] {-1, 1};

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for (char c : t.toCharArray()) {
            freq1.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        int l = 0;
        int r = 0;

        int shortest = Integer.MAX_VALUE;

        int need = freq1.size();
        int have = 0;

        while (r < s.length()) {
            char current = s.charAt(r);

            freq2.compute(current, (k, v) -> v == null ? 1 : v + 1);

            if (freq1.containsKey(current) && freq1.get(current).equals(freq2.get(current))) {
                have++;
            }

            while (have == need) {
                if (r - l + 1 < shortest) {
                    shortest = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);

                freq2.put(leftChar, freq2.get(leftChar) - 1);

                if (freq1.containsKey(leftChar) && freq1.get(leftChar) > freq2.get(leftChar)) {
                    have--;
                }

                l++;
            }

            r++;
        }

        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }
}
