class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        Set<Integer> visited = new HashSet<>();

        for (int[] p : prerequisites) {
            map.putIfAbsent(p[0], new ArrayList<>());
            map.get(p[0]).add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, Set<Integer> visited) {
       
        if(visited.contains(course)) return false;
       
        List<Integer> prereq = map.get(course);

        visited.add(course);

        if(prereq != null) {
        for(int c : prereq) {

            if(!dfs(c, map, visited)) return false;

        }
        }

        visited.remove(course);

        return true;
    }
}
