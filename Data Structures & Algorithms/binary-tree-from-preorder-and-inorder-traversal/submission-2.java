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

class Solution {

    private int preIdx = 0;

    private Map<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Inorder -> Gives us where to split
        // PreOrder -> Shows us how to traverse

        for(int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }

        return buildSubtree(preorder, 0, preorder.length - 1);

    }

    private TreeNode buildSubtree(int[] preorder, int l, int r) {

        if(l > r) return null;
        TreeNode current = new TreeNode(preorder[preIdx++]);
        int mid = indices.get(current.val);
        current.left = buildSubtree(preorder, l, mid - 1);
        current.right = buildSubtree(preorder, mid + 1, r);
        return current;

    }
}
