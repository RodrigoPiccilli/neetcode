class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones) {
            pq.add(n);
        }

        while(pq.size() > 1) {

            int y = pq.remove();
            int x = pq.remove();

            if (x < y) {
                pq.offer(y - x);
            }

        }

        pq.add(0);
        return pq.peek();


    }
}
