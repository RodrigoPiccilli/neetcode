class KthLargest {

    // Min Queue
    PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;

        pq = new PriorityQueue<>();

        for(int n : nums) {

            pq.add(n);

            if(pq.size() > k) {
                pq.remove();
            }

        }

    }
    
    public int add(int val) {

        if(pq.size() != k) {
            pq.add(val);
        } else if(val > pq.peek()) {
            pq.add(val);
            pq.remove();
        }
           
        return pq.peek();

    
    }
}
