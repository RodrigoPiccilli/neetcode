class Solution {

    List<List<Integer>> adjList = new ArrayList<>();
    Set<Integer> cycle = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, -1)) return false;

        return cycle.size() == n;

    }

    private boolean dfs(int node, int parent) {

        if(cycle.contains(node)) return false;

        List<Integer> connections = adjList.get(node);

        cycle.add(node);

        for(int n : connections) {

            if(n == parent) continue;

            if(!dfs(n, node)) return false;

        }

        return true;

    }
}
