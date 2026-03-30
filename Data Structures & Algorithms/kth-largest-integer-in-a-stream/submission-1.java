class KthLargest {

    private PriorityQueue<Integer> pq;

    private int kth;

    public KthLargest(int k, int[] nums) {
        kth = k;
        pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n : nums) {
            pq.offer(n);
        }
    }
    
    public int add(int val) {

        pq.offer(val);

        List<Integer> removed = new ArrayList<>();

        for(int i = 0; i < kth - 1; i++) {
            removed.add(pq.poll());
        }

        int res = pq.peek();

        for(int i = 0; i < removed.size(); i++) {
            pq.offer(removed.get(i));
        }

        return res;
        
    }
}
