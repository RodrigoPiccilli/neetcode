class Solution {

    boolean found = false;

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                backtrack(i, j, board, word, visited, 0);
            }
        }

        return found;

    }

    private void backtrack(int i, int j, char[][] board, String word, boolean[][] visited, int matchIdx) {

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || matchIdx >= word.length()) {
            return;
        }

        if(word.charAt(matchIdx) != board[i][j]) return;

        if(matchIdx + 1 == word.length()) found = true;

        visited[i][j] = true;

        backtrack(i + 1, j, board, word, visited, matchIdx + 1);
        backtrack(i - 1, j, board, word, visited, matchIdx + 1);
        backtrack(i, j + 1, board, word, visited, matchIdx + 1);
        backtrack(i, j - 1, board, word, visited, matchIdx + 1);

        visited[i][j] = false;


    }

}
