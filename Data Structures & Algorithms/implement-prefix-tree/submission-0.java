class PrefixTree {

    public class TrieNode {

        private boolean isCompleteWord;
        private TrieNode[] children;
        private char val;

        public TrieNode() {
            isCompleteWord = false;
            children = new TrieNode[26];
        }

        public TrieNode(char c) {
            this.val = c;
            isCompleteWord = false;
            children = new TrieNode[26];
        }

    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        for(char c : word.toCharArray()) {

            int idx = (c - 'a');

            if(current.children[idx] == null) {
                current.children[idx] = new TrieNode(c);
            }

            current = current.children[idx];

        }

        current.isCompleteWord = true;

    }

    public boolean search(String word) {

        TrieNode current = root;

        for(char c : word.toCharArray()) {

            int idx = c - 'a';

            if(current.children[idx] == null) return false;

            current = current.children[idx];

        }

        return current.isCompleteWord;


    }

    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for(char c : prefix.toCharArray()) {

            int idx = c - 'a';

            if(current.children[idx] == null) return false;

            current = current.children[idx];

        }

        return true;

    }
}
