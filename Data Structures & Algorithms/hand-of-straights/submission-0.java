class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        // Check if group sizes are possible
        if (hand.length % groupSize != 0)
            return false;

        // Count Frequencies
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : hand) {
            freq.compute(n, (k, v) -> v == null ? 1 : v + 1);
        }

        Queue<Integer> minH = new PriorityQueue<>(freq.keySet());

        // [1,2,3,4,5]
        // [2,2,3,3,4,4,5]

        while (!minH.isEmpty()) {
            int min = minH.peek();

            for (int i = min; i < min + groupSize; i++) {
                if (!freq.containsKey(i))
                    return false;

                freq.put(i, freq.get(i) - 1);

                if (freq.get(i) == 0) {
                    if (minH.peek() != i)
                        return false;
                    minH.poll();
                }
            }
        }

        return true;
    }
}
