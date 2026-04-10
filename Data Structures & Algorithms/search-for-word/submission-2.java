class Solution {

    public boolean exist(char[][] board, String word) {

        int ROWS = board.length;
        int COLS = board[0].length;    

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(backtrack(i, j, board, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(int r, int c, char[][] board, int idx, String word) {

        if(idx == word.length()) {
            return true;
        }

        if(r < 0 || c < 0 || r >= board.length || 
            c >= board[0].length || board[r][c] == '#' || board[r][c] != word.charAt(idx)) {
            return false;
        }

        board[r][c] = '#';

        boolean res = backtrack(r + 1, c, board, idx + 1, word) ||
        backtrack(r - 1, c, board, idx + 1, word) ||
        backtrack(r, c + 1, board, idx + 1, word) ||
        backtrack(r, c - 1, board, idx + 1, word);

        board[r][c] = word.charAt(idx);

        return res;

    }
}
