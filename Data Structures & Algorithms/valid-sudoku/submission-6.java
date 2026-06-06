class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] grid = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grid[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] == '.') continue;

                if(!rows[i].add(board[i][j])) return false;
                
                if(!cols[j].add(board[i][j])) return false;
                
                if(!grid[(i / 3) * 3 + (j / 3)].add(board[i][j])) return false;

            }
        }

        return true;
    }
}
