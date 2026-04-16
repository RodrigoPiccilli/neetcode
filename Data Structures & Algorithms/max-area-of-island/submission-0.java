class Solution {
    int ROWS;
    int COLS;

    int max = 0;
    int current = 0;

    public int maxAreaOfIsland(int[][] grid) {
        
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    current = 0;
                    dfs(r, c, grid);
                }
            }
        }

        return max;
    }

    private void dfs(int r, int c, int[][] grid) {

        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) return;

        current++;

        max = Math.max(current, max);

        grid[r][c] = 0;

        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);

    }
}
