class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Key = Number, Value = Frequency
        Map<Integer, Integer> map = new HashMap();

        // Index = Frequency, Value = List of Numbers with Frequency
        List<ArrayList<Integer>> list = new ArrayList();

        for(int num : nums) {
            if(map.get(num) == null) map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }

        for(int i = 0; i < nums.length + 1; i++) {
            list.add(i, new ArrayList());
        }

        for(int key : map.keySet()) {
            list.get(map.get(key)).add(key);
        }
    
        int count = 0;
        int[] solution = new int[k];

        for(int i = list.size() - 1; i >= 0; i--) {

            ArrayList<Integer> vals = list.get(i);

            for(int val : vals) {

                solution[count++] = val;
                
                if(count == k) {
                    return solution;
                }

            }

        }

        return solution;

    }
}
