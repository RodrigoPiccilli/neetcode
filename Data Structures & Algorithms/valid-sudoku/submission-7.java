class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> check = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                if(!check.add(board[i][j] + ", at row " + i)) return false;
                if(!check.add(board[i][j] + ", at column " + j)) return false;
                if(!check.add(board[i][j] + ", at square " + i/3 + " " + j/3)) return false;
            }
        }

        return true;

    }
}
