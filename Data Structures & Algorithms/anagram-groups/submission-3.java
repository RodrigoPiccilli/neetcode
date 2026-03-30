class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> solution = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap();

        for(String s : strs) {

            char[] chars = s.toCharArray();

            int[] count = new int[26];

            for(char c : chars) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            if(map.get(key) == null) map.put(key, new ArrayList());
            map.get(key).add(s);

        }

        for(ArrayList<String> list : map.values()) {
            solution.add(list);
        }

        return solution;
        
    }
}
