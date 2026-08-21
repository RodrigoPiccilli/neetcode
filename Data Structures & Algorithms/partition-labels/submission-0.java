class Solution {
    public List<Integer> partitionLabels(String s) {
        
        Map<Character, Integer> last = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (!last.containsKey(c)) {
                last.put(c, s.lastIndexOf(c));
            }
        }

        int size = 0;
        int maxIdx = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            maxIdx = Math.max(maxIdx, last.get(c));

            size++;

            if (i == maxIdx) {
                res.add(size);
                maxIdx = -1;
                size = 0;
            }
        }

        return res;
    }
}
