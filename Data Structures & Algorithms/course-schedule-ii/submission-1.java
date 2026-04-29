class Solution {

    Set<Integer> path = new HashSet<>(); // Current path
    Set<Integer> visited = new HashSet<>(); // All prereqs have been met
    List<Integer> output = new ArrayList<>(); // Output
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) return new int[] {};
        }

        if(output.size() != numCourses) return new int[] {};

        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            res[i] = output.get(i);
        }

        return res;


    }

    private boolean dfs(int course) {

        if(path.contains(course)) return false;

        if(visited.contains(course)) return true;

        List<Integer> list = map.get(course);

        path.add(course);

        for(int c : list) {
            System.out.println(c + " ! ");
            if(!dfs(c)) return false;
        }

        path.remove(course);

        visited.add(course);

        output.add(course);

        return true;


    }
}
