class Solution {

    List<String> res = new ArrayList<>();

    Map<String, PriorityQueue<String>> adjList = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> t : tickets) {

            String src = t.get(0);

            String dst = t.get(1);

            if(!adjList.containsKey(src)) {
                adjList.put(src, new PriorityQueue<>());
            }

            adjList.get(src).offer(dst);
        }
        
    dfs("JFK");

    Collections.reverse(res);

    return res;

    }

    private void dfs(String src) {

        PriorityQueue<String> pq = adjList.get(src);

        while(pq != null && !pq.isEmpty()) {

            String dst = pq.poll();

            dfs(dst);

        }

        res.add(src);

    }
}
