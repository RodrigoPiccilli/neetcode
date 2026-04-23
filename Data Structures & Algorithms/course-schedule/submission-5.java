class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        Set<Integer> path = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] p : prerequisites) {
            map.get(p[0]).add(p[1]);
        }

       for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, map, path))
            return false;
        }

        return true;


    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, Set<Integer> path) {

        if(path.contains(course)) {
            return false;
        }

        List<Integer> pre = map.get(course);

        if(pre.size() == 0) {
            return true;
        }

        path.add(course);

        for(int c : pre) {
            if(!dfs(c, map, path)) return false;
        }

        path.remove(course);

        return true;
    }
}
