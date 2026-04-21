class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int INF = 2147483647;

        int ROWS = grid.length;

        int COLS = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 0) {
                    q.offer(new int[] {r, c});
                }
            }
        }

        int distance = 1;

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] pos = q.poll();

                int r = pos[0];
                int c = pos[1];

                if(r + 1 >= 0 && r + 1 < ROWS && grid[r + 1][c] == INF) {
                    grid[r + 1][c] = distance;
                    q.offer(new int[] {r + 1, c});
                }

                if(r - 1 >= 0 && r - 1 < ROWS && grid[r - 1][c] == INF) {
                    grid[r - 1][c] = distance;
                    q.offer(new int[] {r - 1, c});
                }

                if(c + 1 >= 0 && c + 1 < COLS && grid[r][c + 1] == INF) {
                    grid[r][c + 1] = distance;
                    q.offer(new int[] {r, c + 1});
                }

                if(c - 1 >= 0 && c - 1 < COLS && grid[r][c - 1] == INF) {
                    grid[r][c - 1] = distance;
                    q.offer(new int[] {r, c - 1});
                }
            
            }

            distance++;

        }


    }
}
