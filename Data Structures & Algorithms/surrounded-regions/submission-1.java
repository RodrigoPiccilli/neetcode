class Solution {

    int ROWS;
    int COLS;

    public void solve(char[][] board) {

        ROWS = board.length;
        COLS = board[0].length;

        boolean[][] marked = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++) {
            dfs(0, c, board, marked);
            dfs(ROWS - 1, c, board, marked);
        }

        for(int r = 0; r < ROWS; r++) {
            dfs(r, 0, board, marked);
            dfs(r, COLS - 1, board, marked);
        }

        for(int r = 1; r < ROWS - 1; r++) {
            for(int c = 1; c < COLS - 1; c++) {
                if(board[r][c] == 'O' && !marked[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
        
    }

    private void dfs(int r, int c, char[][] board, boolean[][] marked) {

        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] == 'X' || marked[r][c]) {
            return;
        }

        marked[r][c] = true;

        dfs(r + 1, c, board, marked);
        dfs(r - 1, c, board, marked);
        dfs(r, c + 1, board, marked);
        dfs(r, c - 1, board, marked);

    }
}
