class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Set<Integer> visited = new HashSet<>();

        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int[] time : times) {

            if(!map.containsKey(time[0])) {
                map.put(time[0], new ArrayList<>());
            }

            map.get(time[0]).add(new int[] {time[1], time[2]});

        }

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.offer(new int[] {k, 0});

        int time = 0;

        while(!pq.isEmpty()) {

            int[] cur = pq.poll();

            if(visited.contains(cur[0])) continue;

            time = cur[1];

            visited.add(cur[0]);

            if(map.containsKey(cur[0])) {

                List<int[]> neighbors = map.get(cur[0]);

                for(int[] nei : neighbors) {

                    if(visited.contains(nei[0])) continue;

                    pq.offer(new int[] {nei[0], nei[1] + cur[1]});

                }

            }

        }

        return visited.size() == n ? time : -1;
        
    }
}
