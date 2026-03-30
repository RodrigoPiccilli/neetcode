class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.equals(t)) return true;

        HashMap<Character, Integer> sMap = new HashMap<>();

        HashMap<Character, Integer> tMap = new HashMap<>();

        char[] sChar = s.toCharArray();

        char[] tChar = t.toCharArray();

        for(char c : sChar) {

            if(sMap.containsKey(c)) {

                sMap.put(c, sMap.get(c) + 1);

            } else {

                sMap.put(c, 1);

            }

        }

        for(char c : tChar) {

            if(tMap.containsKey(c)) {

                tMap.put(c, tMap.get(c) + 1);

            } else {

                tMap.put(c, 1);

            }

        }

        return sMap.equals(tMap);

    }
}
