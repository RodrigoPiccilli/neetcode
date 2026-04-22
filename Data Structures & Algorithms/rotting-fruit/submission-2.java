class Solution {
    public int orangesRotting(int[][] grid) {
        
        int fresh = 0;
        int time = 0;
        int[][] directions = new int[][] {{1 ,0}, {0, 1}, {-1, 0}, {0, -1}};

        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    fresh++;
                } else if(grid[r][c] == 2) {
                    q.offer(new int[] {r, c});
                }
            }
        }

        while(fresh > 0 && !q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] pos = q.poll();

                int r = pos[0];

                int c = pos[1];

                for(int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[] {nc, nr});
                    }

                }

            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
