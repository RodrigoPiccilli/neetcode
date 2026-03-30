class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // We have to remember if we have seen a number in a specific row / column.
        // This hints at the fact that we must use a HashMap.

        HashSet<String> seen = new HashSet();

        for(int i = 0; i < board.length; i++) {

            for(int j = 0; j < board.length; j++) {

                if(board[i][j] == '.') continue;

                if(!seen.add(board[i][j] + " seen at row: " + i)) {
                    return false;
                }

                if(!seen.add(board[i][j] + " seen at column: " + j)) {
                    return false;
                }

                if(!seen.add(board[i][j] + " seen at quadrant: " + i/3 + " : " + j/3)) {
                    return false;
                }


            }
        }

        return true;
    }
}
