class Solution {

    Map<String, PriorityQueue<String>> adjList = new HashMap<>();

    List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);

            adjList.putIfAbsent(src, new PriorityQueue<>());
            adjList.get(src).offer(dst);
        }

        dfs("JFK");

        Collections.reverse(res);

        return res;
    }

    private void dfs(String src) {

        Queue<String> pq = adjList.get(src);

        while(pq != null && !pq.isEmpty()) {

            String dst = pq.poll();
            dfs(dst);

        }

        res.add(src);


    }
}
