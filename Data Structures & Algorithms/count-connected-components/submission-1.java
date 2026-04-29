class Solution {
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    
    public int countComponents(int n, int[][] edges) {

        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] pair : edges) {
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        int count = 0;
        int node = 0;

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(i, -1);
                count++;
            }
        }

        return count;

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
