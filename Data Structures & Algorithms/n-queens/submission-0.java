class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();

        backtrack(n, 0, board, res);

        return res;
    }

    private void backtrack(int n, int r, char[][] board, List<List<String>> res) {
        if (r == n) {
            List<String> current = new ArrayList<>();

            for (char[] row : board) {
                current.add(new String(row));
            }

            res.add(current);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || diag.contains(r - c) || diag2.contains(r + c))
                continue;

            cols.add(c);
            diag.add(r - c);
            diag2.add(r + c);

            board[r][c] = 'Q';

            backtrack(n, r + 1, board, res);

            board[r][c] = '.';
            cols.remove(c);
            diag.remove(r - c);
            diag2.remove(r + c);
        }
    }
}
