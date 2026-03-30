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

        List<String> values = new ArrayList<>();

        dfsEncode(root, values);

        return String.join(",", values);

    }

    private void dfsEncode(TreeNode node, List<String> values) {

        if(node == null) {
            values.add("N");
            return;
        }

        values.add(node.val + "");
        dfsEncode(node.left, values);
        dfsEncode(node.right, values);

    }

    private int idx = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        TreeNode root = dfsDecode(values);

        return root;
        
    }

    private TreeNode dfsDecode(String[] values) {

        if(values[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode current = new TreeNode(Integer.parseInt(values[idx]));
        idx++;

        current.left = dfsDecode(values);
        current.right = dfsDecode(values);

        return current;

    }
}
