class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Key = FREQUENCIES (as string)
        // Value = List of Words

        Map<String, List<String>> map = new HashMap();

        for(String s : strs) {

            int[] count = new int[26];

            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }

            map.get(key).add(s);

        }

        return new ArrayList<List<String>>(map.values());
        
    }
}
