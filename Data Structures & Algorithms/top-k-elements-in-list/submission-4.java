class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // HashMap where key = num, value = frequency

        HashMap<Integer, Integer> map = new HashMap();

        for(int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, (map.get(num) + 1));
        }

        // Number, Frequency

        // Key = Frequency, Value = List of Numbers w/ Frequency
        HashMap<Integer, ArrayList<Integer>> lists = new HashMap();

        for(int num : map.keySet()) {
            
            int freq = map.get(num);
            lists.putIfAbsent(freq, new ArrayList());
            lists.get(freq).add(num);
        }

        int kCount = 0;
        int maxFreq = nums.length;

        int[] solution = new int[k];

        for(int i = nums.length; i >= 0; i--) {

           

            if(lists.get(i) != null) {

                for(int val : lists.get(i)) {
                    solution[kCount++] = val;
                    if(k == kCount) break;
                }

            }

        if(k == kCount) break;

        }

        return solution;

    


        
    }
}
