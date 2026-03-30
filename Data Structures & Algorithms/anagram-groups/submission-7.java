class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Option 1: HashMap<String, List<String>> where key = sorted val & value = list of words
        // Option 2: HashMap<int[], List<String>> where key = count of letters & value = list of words

        // Key = Sorted String; value = List of anagram words
        HashMap<String, ArrayList<String>> map = new HashMap();

        for(String s : strs) { // O(n)

            char[] sorted = s.toCharArray();

            Arrays.sort(sorted); // nLog(n)
            
            String sortedWord = new String(sorted);

            if(map.containsKey(sortedWord)) {
                map.get(sortedWord).add(s);

            } else {
                map.put(sortedWord, new ArrayList<String>());
                map.get(sortedWord).add(s);
            }

        }

        List<List<String>> solution = new ArrayList();

        int index = 0;

        for(ArrayList<String> list : map.values()) {
            solution.add(index, list);
            index++;
        }

        return solution;
        
    }
}
