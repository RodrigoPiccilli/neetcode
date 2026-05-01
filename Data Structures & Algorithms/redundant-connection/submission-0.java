class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    Set<Integer> cycle = new HashSet<>();

    int cycleStart = -1;

    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i <= edges.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pair : edges) {
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        dfs(1, -1);

        for(int i = edges.length - 1; i >= 0; i--) {

            if(cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) {
                return edges[i];
            }

        }

        return new int[] {};
    }

    private boolean dfs(int node, int parent) {
        
        if (visited.contains(node)) {
            cycleStart = node;
            return true;
        }

        List<Integer> nei = adjList.get(node);

        visited.add(node);

        for (int n : nei) {
            if (n == parent)
                continue;

            if (dfs(n, node)) {
                if (cycleStart != -1) cycle.add(node);
                if (node == cycleStart) {
                    cycleStart = -1;
                }
                return true;
            }
        }

        return false;
    }
}
