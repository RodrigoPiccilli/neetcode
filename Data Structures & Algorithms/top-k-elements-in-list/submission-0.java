class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < nums.length + 1; i++) {
            list.add(new ArrayList<>());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.get(num) == null) map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();
            list.get(frequency).add(key);
        }

        int[] solution = new int[k];

        int count = 0;

        for(int i = list.size() - 1; i >= 0; i--) {

            for(int num : list.get(i)) {

                 if(count == k) {
                    break;
                }
                solution[count++] = num;

               
            }

        }

        return solution;

    }
}
