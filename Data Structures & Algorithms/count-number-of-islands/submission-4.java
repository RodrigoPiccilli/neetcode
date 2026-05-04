class Solution {
    
    int ROWS;
    int COLS;

    int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
    
    public int numIslands(char[][] grid) {
        
        ROWS = grid.length;
        COLS = grid[0].length;

        int count = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == '1') {
                    dfs(r, c, grid);
                    count++;
                }
            }
        }

        return count;

    }

    private void dfs(int r, int c, char[][] grid) {

        if(r >= ROWS || c >= COLS || r < 0 || c < 0 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        for(int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            dfs(nr, nc, grid);
        }

    }
}
