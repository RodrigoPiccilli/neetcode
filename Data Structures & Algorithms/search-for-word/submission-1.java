class Solution {

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtrack(i, j, board, word, visited, 0)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean backtrack(int i, int j, char[][] board, String word, boolean[][] visited, int matchIdx) {

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || matchIdx >= word.length()) {
            return false;
        }

        if(word.charAt(matchIdx) != board[i][j]) return false;

        if(matchIdx + 1 == word.length()) return true;

        visited[i][j] = true;

        boolean res = backtrack(i + 1, j, board, word, visited, matchIdx + 1) ||
        backtrack(i - 1, j, board, word, visited, matchIdx + 1) ||
        backtrack(i, j + 1, board, word, visited, matchIdx + 1) ||
        backtrack(i, j - 1, board, word, visited, matchIdx + 1);

        visited[i][j] = false;

        return res;
    }

}
