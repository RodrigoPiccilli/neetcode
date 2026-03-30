class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Bucket Sort

        // List, with its indexes being the frequency. Values are lists of values that occur at that point.

        // We will need a hash map to count the frequencies.

        // KEY = Number, VALUE = Frequency
        Map<Integer, Integer> map = new HashMap();

        for(int n : nums) {
            if(!map.containsKey(n)) map.put(n, 0);
            map.put(n, map.get(n) + 1);
        }

        List<List<Integer>> list = new ArrayList();

        for(int i = 0; i < nums.length + 1; i++) {
            list.add(i, new ArrayList());
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            list.get(e.getValue()).add(e.getKey());
        }

        int[] solution = new int[k];
        int count = 0;

        for(int i = nums.length; i >= 0; i--) {

            for(int n : list.get(i)) {

                solution[count++] = n;

                if(count == k) return solution;

            }

        }

        return solution;

        
    }
}
