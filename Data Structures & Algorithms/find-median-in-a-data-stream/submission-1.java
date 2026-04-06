class MedianFinder {

    PriorityQueue<Double> min;

    public MedianFinder() {
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        min.add((double) num);
    }
    
    public double findMedian() {

        PriorityQueue<Double> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Double> localMin = new PriorityQueue<>(min);
        
        for(int i = 0; i < (min.size() / 2); i++) {
            max.add(localMin.remove());
        }

        // System.out.println(max);
        // System.out.println(localMin);

        return localMin.size() == max.size() ? ((localMin.peek() + max.peek()) / 2) : localMin.peek();

    }
}
