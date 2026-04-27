class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 0) {
                    q.offer(new int[] {r, c});
                }
            }
        }

        int[][] directions = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] pos = q.poll();

                int r = pos[0];

                int c = pos[1];

                for(int[] dir : directions) {

                    int nr = dir[0] + r;
                    int nc = dir[1] + c;

                    if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || grid[nr][nc] != 2147483647) continue;

                    grid[nr][nc] = grid[r][c] + 1;
                    
                    q.offer(new int[] {nr, nc});

                }


            }


        }
        
        





    }
}
