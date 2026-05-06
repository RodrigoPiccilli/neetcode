class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> visited = new HashSet<>();

        // Key = Node #, Value = Array Containing Target Node # and Time
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] time : times) {
            if (!map.containsKey(time[0])) {
                map.put(time[0], new ArrayList<>());
            }
            map.get(time[0]).add(new int[] {time[1], time[2]});
        }

        // [0] -> Node #, [1] -> Time
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[] {k, 0});

        int minTime = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (visited.contains(cur[0]))
                continue;

            visited.add(cur[0]);

            minTime = cur[1];

            List<int[]> neighbors = map.get(cur[0]);

            if (neighbors != null) {
                for (int[] nei : neighbors) {
                    if (visited.contains(nei[0]))
                        continue;
                    pq.offer(new int[] {nei[0], (nei[1] + cur[1])});
                }
            }
        }

        return visited.size() == n ? minTime : -1;
    }
}
