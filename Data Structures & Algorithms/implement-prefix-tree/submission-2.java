class PrefixTree {

    public class TrieNode {

        private boolean isCompleteWord;
        private TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isCompleteWord = false;
        }

    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        for(char c : word.toCharArray()) {

            int idx = c - 'a';

            if(current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }

            current = current.children[idx];

        }

        current.isCompleteWord = true;


    }

    public boolean search(String word) {

        TrieNode current = root;

        for(char c : word.toCharArray()) {

            int idx = c - 'a';

            if(current.children[idx] == null) {
                return false;
            }

            current = current.children[idx];

        }

        return current.isCompleteWord;

    }

    public boolean startsWith(String prefix) {
        
        TrieNode current = root;

        for(char c : prefix.toCharArray()) {

            int idx = c - 'a';

            if(current.children[idx] == null) {
                return false;
            }

            current = current.children[idx];

        }

        return true;
    }
}
