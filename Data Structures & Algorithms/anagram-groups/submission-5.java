class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Lowercase Letters

        Map<String, ArrayList<String>> map = new HashMap();

        for(String s : strs) {

            int[] count = new int[26];

            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            if(map.get(Arrays.toString(count)) == null) map.put(Arrays.toString(count), new ArrayList<String>());

            map.get(Arrays.toString(count)).add(s); 

        }

        List<List<String>> solution = new ArrayList();

        for(ArrayList<String> l : map.values()) {
            solution.add(l);
        }

        return solution;
        
    }
}
