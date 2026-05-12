class Solution {

    Set<Integer> visited = new HashSet<>();

    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int swimInWater(int[][] grid) {
        
        int N = grid.length;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // [0] -> Time / Elevation, [1] -> r, [2] -> c
        pq.offer(new int[] {grid[0][0], 0, 0});

        while(!pq.isEmpty()) {

            int[] cur = pq.poll();

            int t = cur[0];
            int r = cur[1];
            int c = cur[2];

            visited.add(grid[r][c]);

            if(r == N - 1 && c == N - 1) {
                return t;
            }

            for(int[] dir : directions) {

                int nr = dir[0] + r;
                int nc = dir[1] + c;

                if(nr < 0 || nc < 0 
                || nr >= N || nc >= N || visited.contains(grid[nr][nc])) {
                    continue;
                }

                pq.offer(new int[] {Math.max(t, grid[nr][nc]), nr, nc});

            }

        }

        return N * N;

        
    }
}
