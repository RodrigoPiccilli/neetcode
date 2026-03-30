class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n : stones) {
            pq.offer(n);
        }


        while(!pq.isEmpty()) {

            if(pq.size() == 1) return pq.poll();

            int s2 = pq.poll();
            int s1 = pq.poll();

            if(s1 == s2) continue;

            pq.offer(s2 - s1);

        }

        return 0;

    }
}
