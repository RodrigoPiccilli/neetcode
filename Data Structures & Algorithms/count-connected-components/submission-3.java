class Solution {

    List<List<Integer>> adjList = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] pair : edges) {
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                count++;
                dfs(i, -1);
            }
        }

        return count;

    }

    private void dfs(int node, int parent) {

        if(visited.contains(node)) return;

        visited.add(node);

        List<Integer> neighbors = adjList.get(node);

        for(int n : neighbors) {
            if(n == parent) continue;
            dfs(n, node);
        }


    }
}
