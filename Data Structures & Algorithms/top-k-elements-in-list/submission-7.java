class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Input is size n, which would create index 0 to n - 1. We need to add
        // one to make it there is an index n, which is the highest frequency a number can have.
        List<List<Integer>> bucket = new ArrayList<>(nums.length + 1);

        for(int i = 0; i <= nums.length; i++) {
            bucket.add(i, new ArrayList<>());
        }
        
        // KEY = Number, VALUE = Frequency
        Map<Integer, Integer> freq = new HashMap<>();

        // Count Frequencies
        for(int n : nums) {
            freq.putIfAbsent(n, 0);
            freq.put(n, freq.get(n) + 1);
        }

        // Transfer Over Numbers from Map to Appropriate List
        for(int key : freq.keySet()) {
            bucket.get(freq.get(key)).add(key);
        }

        // Result array, size k
        int[] res = new int[k];
        
        // Counter to indicate how much of our result array have been filled up already.
        int count = 0;

        // Iterate list of lists backwards; gives us the list containing the highest frequency numbers.
        for(int i = bucket.size() - 1; i >= 0; i--) {

            // Get List
            List<Integer> cur = bucket.get(i);

            // Iterate through list, adding all elements in the list to res array.
            // The way the problem is structured allows us to guarantee that if the top k elements
            // are all in the same frequency list, that they will all be included.
            for(int j = 0; j < cur.size(); j++) {
                res[count++] = cur.get(j);
                if(count == k) return res;
            }

        }

        return res;

    }
}
