class Solution {

    int ROWS;
    int COLS;
    

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        ROWS = heights.length;
        COLS = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++) {
            dfs(0, c, heights, pacific);
            dfs(ROWS - 1,c ,heights, atlantic);
        }

        for(int r = 0; r < ROWS; r++) {
            dfs(r, 0, heights, pacific);
            dfs(r, COLS - 1, heights, atlantic);
        }

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;

        
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean) {

        ocean[r][c] = true;

        if(r + 1 >= 0 && r + 1 < ROWS && !ocean[r + 1][c] && heights[r + 1][c] >= heights[r][c]) {
            dfs(r + 1, c, heights, ocean);
        }

        if(r - 1 >= 0 && r - 1 < ROWS && !ocean[r - 1][c] && heights[r - 1][c] >= heights[r][c]) {
            dfs(r - 1, c, heights, ocean);
        }

        if(c + 1 >= 0 && c + 1 < COLS && !ocean[r][c + 1] && heights[r][c + 1] >= heights[r][c]) {
            dfs(r, c + 1, heights, ocean);
        }

        if(c - 1 >= 0 && c - 1 < COLS && !ocean[r][c - 1] && heights[r][c - 1] >= heights[r][c]) {
            dfs(r, c - 1, heights, ocean);
        }



    }
}
