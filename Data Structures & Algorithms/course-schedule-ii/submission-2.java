class Solution {

    List<Integer> output = new ArrayList<>();
    Set<Integer> completed = new HashSet<>();
    Set<Integer> path = new HashSet<>();

    // KEY = Course, VALUE = List of Prerequisites
    Map<Integer, List<Integer>> pre = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for(int i = 0; i < numCourses; i++) {
            pre.put(i, new ArrayList<>());
        }

        for(int[] pair : prerequisites) {
            pre.get(pair[0]).add(pair[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) return new int[] {};
        }

        int[] res = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            res[i] = output.get(i);
        }

        return res;

    }

    private boolean dfs(int course) {

        if(path.contains(course)) return false;

        if(completed.contains(course)) return true;

        path.add(course);

        List<Integer> prereq = pre.get(course);

        for(int c : prereq) {
            if(!dfs(c)) return false;
        }

        path.remove(course);

        completed.add(course);

        output.add(course);

        return true;


    }
}
