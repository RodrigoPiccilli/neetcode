class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> check = new HashSet();

        for(int i = 0; i < 9; i++) {

            for(int j = 0; j < 9; j++) {

                if(board[i][j] == '.') continue;

                if(!check.add(board[i][j] + "at row " + board[i])) return false;

                if(!check.add(board[i][j] + "at column " + board[j])) return false;

                if(!check.add(board[i][j] + "at quadrant " + i/3 + j/3)) return false;

            }

        }

        return true;

    }
}
