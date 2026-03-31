class Solution {

    class TrieNode {

        private boolean isCompleteWord;
        private TrieNode[] children;

        public TrieNode() {
            this.isCompleteWord = false;
            children = new TrieNode[26];
        }

    }

    

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();
        populateTrie(words, root);
        Set<String> res = new HashSet<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                searchBoard(i, j, root, "", board, res);
            }
        }

        return new ArrayList<>(res);

    }

    private void populateTrie(String[] words, TrieNode root) {

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

    private void searchBoard(int row, int col, TrieNode node, String word, char[][] board, Set<String> res) {

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;

        char c = board[row][col];

        if(c == '*') return;

        int idx = c - 'a';

        if(node.children[idx] == null) {
            return;
        }

        word += c;

        if(node.children[idx].isCompleteWord) res.add(word);

        board[row][col] = '*';

        searchBoard(row - 1, col, node.children[idx], word, board, res);
        searchBoard(row + 1, col, node.children[idx], word, board, res);
        searchBoard(row, col - 1, node.children[idx], word, board, res);
        searchBoard(row, col + 1, node.children[idx], word, board, res);
        
        board[row][col] = c;

    }


}
