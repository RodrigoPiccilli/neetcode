class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Use a HashMap, where KEY = count array (as string) and VALUE = array list of anagrams

        Map<String, List<String>> map = new HashMap();

        for(String s : strs) { // act, cat, pots, stop

            char[] letters = s.toCharArray();

            int[] count = new int[26];

            for(char c : letters) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            if(map.get(key) == null) {
                map.put(key, new ArrayList());
            }

            map.get(key).add(s);
            
        }

        return new ArrayList(map.values());

    }
}
