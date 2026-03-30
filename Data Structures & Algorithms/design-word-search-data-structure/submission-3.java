class WordDictionary {

    public class TrieNode {

        private boolean isWord;
        private Map<Character, TrieNode> children;

        public TrieNode() {
            this.isWord = false;
            this.children = new HashMap<>();
        }

    }


    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for(char c : word.toCharArray()) {

            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);

        } 

        current.isWord = true;

    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, TrieNode current, int idx) {

        for(int i = idx; i < word.length(); i++) {

            char c = word.charAt(i);

            if(c == '.') {

                for(TrieNode child : current.children.values()) {
                    if(dfs(word, child, i + 1)) {
                        return true;
                    }
                }

                return false;

            } else if(current.children.get(c) == null) {
                return false;
            }

            current = current.children.get(c);

        }

        return current.isWord;
    }



}
