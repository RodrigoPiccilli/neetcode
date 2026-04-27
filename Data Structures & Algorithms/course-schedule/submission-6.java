class Solution {

    Set<Integer> set = new HashSet<>();

    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] c : prerequisites) {
            map.get(c[0]).add(c[1]);
        }

        for(int[] c : prerequisites) {
            if(!dfs(c[0])) return false;
        }

        return true;
        
    }

    private boolean dfs(int course) {

        if(set.contains(course)) return false;

        if(map.get(course).isEmpty()) return true;

        List<Integer> pre = map.get(course);

        set.add(course);

        for(int c : pre) {
            if(!dfs(c)) return false;
        }

        map.put(course, new ArrayList<>());

        set.remove(course);

        return true;

    }
}
