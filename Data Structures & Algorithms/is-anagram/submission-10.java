class Solution {
    public boolean isAnagram(String s, String t) {

        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        // Brute Force

        // Sort, then see if Equals n(log(n))

        // Two HashMaps, checking for the same content O(n)

        HashMap<Character, Integer> sMap = new HashMap();
        HashMap<Character, Integer> tMap = new HashMap();

        for(char c : s.toCharArray()) {
            if(sMap.get(c) != null) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }

        for(char c : t.toCharArray()) {
            if(tMap.get(c) != null) {
                tMap.put(c, tMap.get(c) + 1);
            } else {
                tMap.put(c, 1);
            }
        }

        return sMap.equals(tMap);


    }
}
