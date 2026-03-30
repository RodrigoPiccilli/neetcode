class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {

            if(map.containsKey(s.charAt(i))) {

                int count = map.get(s.charAt(i));

                map.put(s.charAt(i), ++count);

            } else {

                map.put(s.charAt(i), 1);


            }

            if(map.containsKey(t.charAt(i))) {

                int count = map.get(t.charAt(i));

                map.put(t.charAt(i), --count);

            } else {

                map.put(t.charAt(i), -1);


            }


        }

        for(int i = 0; i < s.length(); i++) {

            if(map.get(s.charAt(i)) != 0) return false;
            

        }

        return true;



    }
}
