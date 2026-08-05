class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;

        int l = 0;
        int r = s1.length();

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            freq1.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        for (int i = 0; i < r; i++) {
            freq2.compute(s2.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        if (freq2.equals(freq1)) {
            return true;
        }

        while (r < s2.length()) {

            char c1 = s2.charAt(l);
            char c2 = s2.charAt(r);

            freq2.compute(c1, (k, v) -> v == 1 ? null : v - 1);

            freq2.compute(c2, (k, v) -> v == null ? 1 : v + 1);

            if (freq2.equals(freq1)) {
                return true;
            }

            l++;
            r++;
        }

        return false;
    }
}
