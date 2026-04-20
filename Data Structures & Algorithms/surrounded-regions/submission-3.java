class Solution {

    int ROWS;
    int COLS;

    public void solve(char[][] board) {
        
        ROWS = board.length;
        COLS = board[0].length;

        for(int c = 0; c < COLS; c++) {
            dfs(0, c, board);
            dfs(ROWS - 1, c, board);
        }

        for(int r = 0; r < ROWS; r++) {
            dfs(r, 0, board);
            dfs(r, COLS - 1, board);
        }

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if(board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }


    }

    private void dfs(int r, int c, char[][] board) {

        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] == 'X' || board[r][c] == 'T') {
            return;
        }

        board[r][c] = 'T';

        dfs(r - 1, c, board);
        dfs(r + 1, c, board);
        dfs(r, c - 1, board);
        dfs(r, c + 1, board);

    }

}
