class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet();

        for(int i = 0; i < 9; i++) {

            for(int j = 0; j < 9; j++) {

                if(board[i][j] == '.') continue;

                if(!seen.add(board[i][j] + " seen at row " + i)) return false;
                if(!seen.add(board[i][j] + " seen at col " + j)) return false;
                if(!seen.add(board[i][j] + " seen at grid " + i/3 + j/3)) return false;

            }


        }

        return true;
        
    }
}
