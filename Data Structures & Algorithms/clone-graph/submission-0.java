/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) return null;
        
        Map<Integer, Node> clones = new HashMap<>();

        dfs(node, clones);

        return clones.get(node.val);

    }

    public void dfs(Node node, Map<Integer, Node> clones) {

        if(clones.get(node.val) != null) return;

        clones.put(node.val, new Node(node.val));

        Node current = clones.get(node.val);

        for(Node n : node.neighbors) {
            dfs(n, clones);
            current.neighbors.add(clones.get(n.val));
        }

    }


}