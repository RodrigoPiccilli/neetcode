class Solution {

    int res = 0;

    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    Set<Integer> visited = new HashSet<>();

    public int swimInWater(int[][] grid) {

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // [0] -> Elevation, [1] -> Row, [2] -> Col
        pq.offer(new int[] {grid[0][0], 0, 0});
        visited.add(grid[0][0]);

        while(!pq.isEmpty()) {

            int[] cur = pq.poll();

            int t = cur[0];
            int r = cur[1];
            int c = cur[2];


            if(r == grid.length - 1 && c == grid.length - 1) {
                return t;
            }

            for(int[] d : directions) {

                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 
                || nr >= grid.length 
                || nc >= grid.length 
                || visited.contains(grid[nr][nc])) continue;

                visited.add(grid[nr][nc]);
                pq.offer(new int[] {Math.max(t, grid[nr][nc]), nr, nc});


            }

        }


        return grid.length;


    }

   


}
