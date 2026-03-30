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
        String[] res = data.split(",");
        return dfsDecode(res);
    }

    private TreeNode dfsDecode(String[] res) {

        if(res[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(res[idx++]));

        node.left = dfsDecode(res);
        node.right = dfsDecode(res);

        return node;


    }


}
