class Solution {

    class TrieNode {

        private boolean isCompleteWord;
        private TrieNode[] children;

        public TrieNode() {
            isCompleteWord = false;
            children = new TrieNode[26];
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();

        boolean[][] visited = new boolean[board.length][board[0].length];

        populateTrie(root, words);

        Set<String> res = new HashSet<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                searchBoard(root, i, j, board, visited, "", res);
            }
        }

        return new ArrayList<>(res);


    }

    private void populateTrie(TrieNode root, String[] words) {

        for(String s : words) {

            TrieNode current = root;

            for(char c : s.toCharArray()) {

                int idx = c - 'a';

                if(current.children[idx] == null) {
                    current.children[idx] = new TrieNode();
                }

                current = current.children[idx];

            }

            current.isCompleteWord = true;

        }

    }

    private void searchBoard(TrieNode current, int row, int col, char[][] board, boolean[][] visited, String word, Set<String> res) {

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }

        if(visited[row][col]) return;

        char c = board[row][col];

        int idx = c - 'a';

        if(current.children[idx] == null) return;

        word += c;

        if(current.children[idx].isCompleteWord) res.add(word);

        visited[row][col] = true;

        searchBoard(current.children[idx], row - 1, col, board, visited, word, res);
        searchBoard(current.children[idx], row + 1, col, board, visited, word, res);
        searchBoard(current.children[idx], row, col - 1, board, visited, word, res);
        searchBoard(current.children[idx], row, col + 1, board, visited, word, res);

        visited[row][col] = false;

    }
}
