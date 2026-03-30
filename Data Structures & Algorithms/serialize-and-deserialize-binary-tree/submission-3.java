/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        List<String> nodes = new ArrayList<String>();

        dfsEncode(root, nodes);

        return String.join("," , nodes);
    }

    private void dfsEncode(TreeNode node, List<String> nodes) {

        if(node == null) {
            nodes.add("N");
            return;
        }

        nodes.add(node.val + "");
        dfsEncode(node.left, nodes);
        dfsEncode(node.right, nodes);

    }

    private int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] nodes = data.split(",");
    
        return dfsDecode(nodes);

    }

    private TreeNode dfsDecode(String[] nodes) {

        if(nodes[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode current = new TreeNode(Integer.parseInt(nodes[idx++]));

        current.left = dfsDecode(nodes);
        current.right = dfsDecode(nodes);

        return current;

    }

}
