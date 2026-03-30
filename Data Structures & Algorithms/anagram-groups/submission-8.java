class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // HashMap where KEY = string (to string on char[]), value = List<String> with words

        Map<String, List<String>> map = new HashMap();

        for(String s : strs) {

            int[] letters = new int[26];

            for(char c : s.toCharArray()) {
                letters[c - 'a']++;
            }

            String key = Arrays.toString(letters);

            if(map.get(key) == null) {
                map.put(key, new ArrayList());
            }

            map.get(key).add(s);

        }

        List<List<String>> solution = new ArrayList();

        for(List<String> value : map.values()) {
            solution.add(value);
        }


        return solution;


    }
}
