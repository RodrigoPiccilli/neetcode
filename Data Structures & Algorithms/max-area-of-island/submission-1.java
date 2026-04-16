class Solution {
    int ROWS;
    int COLS;

    public int maxAreaOfIsland(int[][] grid) {
        
        ROWS = grid.length;
        COLS = grid[0].length;

        int max = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    max = Math.max(max, dfs(r, c, grid));
                }
            }
        }

        return max;
    }

    private int dfs(int r, int c, int[][] grid) {

        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) return 0;

        grid[r][c] = 0;

        return 1 + dfs(r + 1, c, grid) + dfs(r - 1, c, grid)
         + dfs(r, c + 1, grid)
        + dfs(r, c - 1, grid);

    }
}
