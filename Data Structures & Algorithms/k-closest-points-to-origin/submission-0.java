class Solution {
    public int[][] kClosest(int[][] points, int k) {

        class Pair {

            private double distance;
            private int idx;

            public Pair(double distance, int idx) {
                this.distance = distance;
                this.idx = idx;
            }

        }

        // Min Heap? Pre calculate the distances beforehand, insert them into the heap,
        // and pop k from heap.

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));

        for(int i = 0; i < points.length; i++) {

            double distance = Math.sqrt(Math.pow(points[i][0] - 0, 2) + Math.pow(points[i][1] - 0, 2));

            pq.add(new Pair(distance, i));
        }

        int[][] res = new int[k][2];

        for(int i = 0; i < k; i++) {

            Pair current = pq.remove();
            res[i] = new int[] {points[current.idx][0], points[current.idx][1]};

        }

        return res;


        

    }
}
