class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1) return false;

        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] pair : edges) {
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        dfs(0, -1);
        
        return visited.size() == n;

    }

    private void dfs(int node, int parent) {

        if(visited.contains(node)) return;

        visited.add(node);

        List<Integer> connected = map.get(node);

        for(int c : connected) {
            if(c == parent) continue;
            dfs(c, node);
        }


    }
}
