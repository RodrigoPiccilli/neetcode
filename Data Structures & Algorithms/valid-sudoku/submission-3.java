class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Idea: Use HashSet to validate column, row, and square

        Set<String> set = new HashSet();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                if(board[i][j] == '.') continue;

                if(!(set.add("Found " + board[i][j] + "in row " + i))) return false;

                if(!(set.add("Found " + board[i][j] + "in column " + j))) return false;

                if(!(set.add("Found " + board[i][j] + "in square " + i/3 + j/3))) return false;
            }
        }

        return true;
    }
}
