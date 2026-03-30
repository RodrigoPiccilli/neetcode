class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Count Frequencies
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int num : nums) {
            if(!count.containsKey(num)) count.put(num, 0);
            count.put(num, count.get(num) + 1);
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList();

        for(int i = 0; i < nums.length + 1; i++) {
            list.add(new ArrayList());
        }

        for(int key : count.keySet()) {
            list.get(count.get(key)).add(key);
        }

        int[] solution = new int[k];
        int counter = 0;

        for(int i = list.size() - 1; i >= 0; i--) {

            for(int j = 0; j < list.get(i).size(); j++) {
                solution[counter] = list.get(i).get(j);
                counter++;
                if(counter == k) return solution;
            }
        }

        return null;



       
        
    }
}
