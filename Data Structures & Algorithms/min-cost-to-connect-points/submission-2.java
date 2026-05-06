class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        Set<Integer> visited = new HashSet<>();

        // [0] -> Weight, [1] -> Index
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int cost = 0;

        pq.offer(new int[] {0, 0});

        while(visited.size() != points.length) {

            int[] cur = pq.remove();

            if(visited.contains(cur[1])) continue;

            cost += cur[0];

            visited.add(cur[1]);

            for(int i = 0; i < points.length; i++) {

                if(visited.contains(i)) continue;

                pq.offer(new int[] {dist(points[i], points[cur[1]]), i});

            }
            
        }

        return cost;


    }


    private int dist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
