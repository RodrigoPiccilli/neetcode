class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, Integer> map = new HashMap<>();
        List<List<String>> solution = new ArrayList<>(strs.length);

        int indexCount = 0;

        for(String s : strs) {

            char[] stringAsChar = s.toCharArray();

            Arrays.sort(stringAsChar);

            String sorted = new String(stringAsChar);

            if(map.get(sorted) == null) {
                map.put(sorted, indexCount);
                solution.add(indexCount, new ArrayList<>());
                solution.get(indexCount).add(s);
                indexCount++;
            } else {
                solution.get(map.get(sorted)).add(s);
            }

        }

        return solution;

    }
}
