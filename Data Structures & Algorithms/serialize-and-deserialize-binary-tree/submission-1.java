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
        
        List<String> res = new ArrayList<>();
        dfsEncode(root, res);
        return String.join(",", res);
        
    }

    private void dfsEncode(TreeNode node, List<String> res) {

        if(node == null) {
            res.add("N");
            return;
        }

        res.add(node.val + "");
        dfsEncode(node.left, res);
        dfsEncode(node.right, res);

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

        TreeNode node = new TreeNode(Integer.parseInt(nodes[idx++]));

        node.left = dfsDecode(nodes);
        node.right = dfsDecode(nodes);

        return node;

    }
}
