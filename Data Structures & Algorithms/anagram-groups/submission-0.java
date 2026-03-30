class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> output = new ArrayList<>();

        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {

            char sorted[] = strs[i].toCharArray();
            Arrays.sort(sorted);

            String sortedString = new String(sorted);

            if(anagrams.containsKey(sortedString)) {
                anagrams.get(sortedString).add(strs[i]);
            } else {
                anagrams.put(sortedString, new ArrayList<String>());
                anagrams.get(sortedString).add(strs[i]);
            }

        }

        for(ArrayList<String> list : anagrams.values()) {

            output.add(list);

        }

        return output;


    }
}
