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

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        max = Math.max(max, dfs(root.left) + dfs(root.right));

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return max;
        
    }

    private int dfs(TreeNode root) {

        if(root == null) return 0;

        return Math.max(dfs(root.left), dfs(root.right)) + 1;


    }
}
