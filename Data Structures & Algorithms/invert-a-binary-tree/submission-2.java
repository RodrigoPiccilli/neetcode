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
    public TreeNode invertTree(TreeNode root) {
        
    // Base Case
        if(root == null) return root;
    // Recursive Case

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = invertTree(left);
        root.left = invertTree(right);

      return root;

    }
}
