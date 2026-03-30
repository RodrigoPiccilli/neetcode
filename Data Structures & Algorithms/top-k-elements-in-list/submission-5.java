class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Bucket sort variation

        // At most, a number can appear nums.length times.


        // KEY = Number, VALUE = Frequency
        Map<Integer, Integer> map = new HashMap(); 
        
        for(int n : nums) {
            if(map.get(n) == null) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }

        // INDEX = Frequency
        // INNER LIST = Numbers that appear at that frequency

        List<List<Integer>> bucket = new ArrayList();

        for(int i = 0 ; i < nums.length + 1; i++) {
            bucket.add(i, new ArrayList());
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            bucket.get(e.getValue()).add(e.getKey());
        }

        int[] solution = new int[k];

        int count = 0;

        for(int i = bucket.size() - 1; i >= 0; i--) {

            for(int n : bucket.get(i)) {

                solution[count] = n;
                count++;

                if(count == k) return solution;

            }

            if(count == k) break;

        }

        return solution;
 


        
    }
}
