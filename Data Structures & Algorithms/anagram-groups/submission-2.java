class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<HashMap<Character, Integer>, List<String>> result = new HashMap<>();

        for(String s : strs) {

            HashMap<Character, Integer> freq = count(s);

            if(result.get(freq) == null) result.put(freq, new ArrayList<String>());

            result.get(freq).add(s);
        }

        List<List<String>> solution = new ArrayList<>();

        for(List<String> list : result.values()) {
            solution.add(list);
        }

        return solution;
        
    }

    private HashMap<Character, Integer> count(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
    
        for(char c : s.toCharArray()) {
            if(map.get(c) == null) map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }

        return map;

    }
}
